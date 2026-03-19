package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Chrome options for headless Jenkins
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");           // Headless mode
        options.addArguments("--no-sandbox");             // Required for Linux CI
        options.addArguments("--disable-dev-shm-usage");  // Avoid shared memory issues
        options.addArguments("--disable-gpu");            // Optional
        options.addArguments("--window-size=1920,1080");  // Ensure proper layout

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Navigate to login page
        driver.get("https://admin-demo.nopcommerce.com/login");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Take screenshot on failure
        if (result.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(result.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenshot(String testName) {
        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "target/screenshots/" + testName + ".png";
            FileUtils.copyFile(srcFile, new File(path));
            System.out.println("Screenshot saved: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
