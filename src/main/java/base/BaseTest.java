package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * This class contain the before method that will open the browser
 * and the after method that will close the browser for each test
 * */
public class BaseTest {
    protected WebDriver driver;
    protected Logger log;
    protected  String testSuiteName;
    protected  String testName;
    protected  String testMethodName;

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        //Here the browser is passed to BrowserDriverFactor class
        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);

        //Create driver
        driver = factory.createDriver();
        driver.manage().window().maximize();

        //This information will be used to set more information in the log message
        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
        this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
