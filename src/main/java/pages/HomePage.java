package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * This class contain the web elements located on the Home page as well as some actions
 * performed on this page
 */
public class HomePage extends BasePageObject {

    private By searchGoogleLocator = By.xpath("//input[@name='q']");
    private By googleLabelLocator = By.cssSelector(".ddlmdsb-Dc");
    private By SearchBtnLocator = By.cssSelector(".gNO89b");
    private By focusSerLnkLocator = By.xpath("//h3[text()='Focus Services – Beyond Expectations']");
    private By nowHiringBtnLocator = By.xpath("//span[text()='Now Hiring!']");

    public HomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * This method search for Focus Services page
     **/
    public void goToHomePage() {
        log.info("Opening Chrome Browser");
        openUrl("http://www.google.com");
        log.info("Typing in Google’s search “Focus Services”");
        type("Focus Services", searchGoogleLocator);
        //click(googleLabelLocator);
        log.info("Searching 'Focus Services' link");
        click(SearchBtnLocator);
        log.info("Clicking on 'Search button'");
    }

    /**
     * This method validates if 'www.focusservices.com' URL exists on the page
     **/
    public void validateTextInf(String text) {
        String sourcePage = driver.getPageSource();
        Assert.assertTrue(sourcePage.contains("www.focusservices.com"),
                "www.focusservices.com URL was not found");
        log.info("The '" + text + "' " + "URL was found");

    }

    /**
     * This method clicks on Focus Services link
     **/
    public void clickLinkPage() {
        click(focusSerLnkLocator);
        log.info("Clicking on 'Focus Services' link");
    }

    /**
     * This method validates if 'Now Hiring' button exists
     **/
    public void validateNowHiringBtn() {
        String text = find(nowHiringBtnLocator).getText();
        Assert.assertTrue(text.contains("Now Hiring"),
                "Now Hiring button was not found");
        log.info("The '" + text + "' " + "button was found");
    }
}
