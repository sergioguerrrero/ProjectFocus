package base;

import org.openqa.selenium.JavascriptExecutor;

public class TestUtilities extends BaseTest{


    /**
     * This method sleeps the browser
     **/
    protected void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * This method scroll down to the footer page
     **/
    protected void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        log.info("Scroll down was performed to the footer page");
    }

    /**
     * This method scroll on the page
     **/
    protected void scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)", "");
        log.info("Scroll down was performed");
    }
}
