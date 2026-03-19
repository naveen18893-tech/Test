package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Path for the HTML report
            String reportPath = System.getProperty("user.dir") + "/target/ExtentReport.html";

            // Create Spark reporter
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);

            // Configure report style
            reporter.config().setReportName("Automation Test Report"); // Report header
            reporter.config().setDocumentTitle("Test Results");        // Browser tab title
            reporter.config().setTheme(Theme.DARK);                    // Dark theme with better colors
            reporter.config().setTimelineEnabled(true);               // Adds a timeline view
            reporter.config().setEncoding("UTF-8");                   // Ensure correct encoding

            // Initialize ExtentReports
            extent = new ExtentReports();
            extent.attachReporter(reporter);

            // Optional: add system info for context in Jenkins builds
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
