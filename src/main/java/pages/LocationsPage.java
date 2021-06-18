package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LocationsPage extends BasePageObject{

    private By locationsLnkLocator = By.xpath("//span[text()='Locations']");
    private By northAmerLnkLocator = By.xpath("//span[text()='North America']");
    private By centralAmerLnkLocator = By.xpath("//span[text()='Central America']");
    private By esNcLocator = By.xpath("//h2[text()='El Salvador & Nicaragua']");
    private By asiaLocator = By.xpath("//span[text()='Asia']");
    private By bacolodLocator = By.xpath("//b[text()='Bacolod City, Philippines']");

    public LocationsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * This method clicks on 'locations' link
     **/
    public void goToLocationsPage(){
        click(locationsLnkLocator);
        log.info("Clicking on 'locations' Tab");
    }

    /**
     * This method clicks on 'North America' link
     **/
    public void clickNorthAmerLnk(){
        log.info("Clicking on 'North America' link");
        click(northAmerLnkLocator);
        Assert.assertTrue(find(northAmerLnkLocator).getText().contains("NORTH AMERICA"),
                "North America link was not found");
        log.info("The 'North America' link was found");
    }

    /**
     * This method clicks on 'Central America' link
     **/
    public void clickCentralAmerLnk(){
        log.info("Clicking on 'Central America' link");
        click(centralAmerLnkLocator);
        Assert.assertTrue(find(centralAmerLnkLocator).getText().contains("CENTRAL AMERICA"),
                "Central America link was not found");
        log.info("The 'Central America' link was found");
    }

    /**
     * This method validates if 'El Salvador & Nicaragua' text appear on the locations page
     **/
    public void validateEsTitle(){
        String text=find(esNcLocator).getText();
        Assert.assertTrue(text.contains("El Salvador & Nicaragua"),
                "El Salvador & Nicaragua text was not found");
        log.info("The 'El Salvador & Nicaragua' text was found");
    }

    /**
     * This method clicks on 'Asia' link
     **/
    public void clickAsiaLnk(){
        log.info("Clicking on 'Asia' link");
        click(asiaLocator);
        Assert.assertTrue(find(asiaLocator).getText().contains("ASIA"),
                "Asia link was not found");
    }

    /**
     * This method validates if 'Bacolod City, Philippines' text appear on the locations page
     **/
    public void validateBacolodTitle(){
        String text=find(bacolodLocator).getText();
        Assert.assertTrue(text.contains("Bacolod City, Philippines"),
                "Bacolod City, Philippines text was not found");
        log.info("The 'Bacolod City, Philippines' text was found");
    }
}
