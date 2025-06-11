package util;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getReporter() {
        try {
            ExtentSparkReporter reporter = new ExtentSparkReporter("target/extent-report.html");
            reporter.config().setReportName("Sicredi API Test Report");
            reporter.config().setDocumentTitle("Sicredi API - Test Results");

            extentReports.attachReporter(reporter);
        } catch (Exception e) {
            System.out.println("Erro ao criar ExtentReport: " + e.getMessage());
        }
        return extentReports;
    }
}