package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Default timeout (can be adjusted in constructor)
    private static final int DEFAULT_TIMEOUT = 15;

    // Locators
    private final By usernameField = By.id("Email");      // Make sure this matches actual page
    private final By passwordField = By.id("Password");   // Make sure this matches actual page
    private final By loginButton = By.xpath("//button[text()='Log in']");

    // Constructor with default timeout
    public LoginPage(WebDriver driver) {
        this(driver, DEFAULT_TIMEOUT);
    }

    // Constructor with custom timeout
    public LoginPage(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public void enterUsername(String username) {
        try {
            WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
            userField.clear();
            userField.sendKeys(username);
        } catch (Exception e) {
            System.err.println("Username field not found: " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
            passField.clear();
            passField.sendKeys(password);
        } catch (Exception e) {
            System.err.println("Password field not found: " + e.getMessage());
        }
    }

    public void clickLogin() {
        try {
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginBtn.click();
        } catch (Exception e) {
            System.err.println("Login button not found or not clickable: " + e.getMessage());
        }
    }
}
