import util.ExtentManager;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public abstract class BaseTest {
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeAll
    public static void setup() {
        extent = ExtentManager.getReporter();
        RestAssured.baseURI = "https://dummyjson.com";
        RestAssured.basePath = "/";
    }

    @AfterAll
    public static void tearDown() {
        extent.flush();
    }
}
