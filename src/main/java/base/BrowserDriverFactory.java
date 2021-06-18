package base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * In this class, the driver's properties are set
 */
public class BrowserDriverFactory {
    //driver variable will be available in any class
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger log;

    /**
     * Constructor
     **/
    public BrowserDriverFactory(String browser, Logger log){
        this.browser = browser.toLowerCase();
        this.log = log;
    }

    /**
     * This method sets the driver
     **/
    public WebDriver createDriver() {
        //Create browser
        log.info("Create driver: " + browser);
        //set Chrome Driver
        if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver.set(new ChromeDriver());
        } else if ("firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver.set(new FirefoxDriver());
        } else {
            System.out.println("Do not know how to star:" + browser + ", starting Chrome.");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver.set(new ChromeDriver());
        }
        return driver.get();
    }
}
