package automationTest;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LocationsPage;

public class TestFocus extends TestUtilities{
    @Test
    public void focusTest(){
        HomePage home = new HomePage(driver,log);
        LocationsPage locations= new LocationsPage(driver,log);
        home.goToHomePage();
        home.validateTextInf("www.focusservices.com");
        home.clickLinkPage();
        scrollDown();
        home.validateNowHiringBtn();
        locations.goToLocationsPage();
        scroll();
        locations.clickNorthAmerLnk();
        locations.clickCentralAmerLnk();
        locations.validateEsTitle();
        locations.clickAsiaLnk();
        locations.validateBacolodTitle();
    }
}
