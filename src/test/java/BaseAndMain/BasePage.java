package BaseAndMain;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
public class BasePage {

    // waiting for element to be clickable
    public void waitForElementToBeClickable(By by){
        try {
            DriverSingleton.getWebDriverWaitInstance().until(ExpectedConditions.elementToBeClickable(by));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // take screenshot and add to report at any fail
    public void takeScreenShotAndAddToReport(){
        String timeNow = String.valueOf(System.currentTimeMillis());
        POMTest.test.fail("ScreenShot", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
    }

    // send pass to report
    public void setReportPassed(String details){
        POMTest.test.pass(details);
    }

    // send fail to report
    public void setReportFailed(String details){
        POMTest.test.log(Status.FAIL,details);
        takeScreenShotAndAddToReport();
    }

    // Read from data.xml (Website, Driver type)
    public static String getDataFromXML (String keyName) {
        File fXmlFile = new File("C:\\Users\\user\\IdeaProjects\\BuyMeProject\\src\\main\\resources\\data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {

        }
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    // send keys to element function
    public void sendKeysToElement(By locator, String text){
        try {
            getWebElement(locator).sendKeys(text);
            setReportPassed("Send keys to element Passed");
        }
        catch (Exception e){
            setReportFailed("Failed to send keys to element");
            System.out.println(e.getMessage());
        }
    }

    // click on element function
    public void clickElement(By locator){
        try {
            getWebElement(locator).click();
            setReportPassed("Click element Passed");
        }
        catch (Exception e){
            setReportFailed("Failed to click on element");
            System.out.println(e.getMessage());
        }
    }

    // getting the web element
    public WebElement getWebElement(By locator){
        WebElement element = null;
        String timeNow = String.valueOf(System.currentTimeMillis());
        try {
            element = DriverSingleton.getDriverInstance().findElement(locator);
            setReportPassed("get Web element successfully");
        } catch (Exception e) {
            setReportFailed("Failed to get the Web element");
            System.out.println(e.getMessage());
        }
        return element;
    }

    // take Screen shot of the website
    public String takeScreenShot(String ImagesPath){
        try{
            TakesScreenshot takesScreenshot = (TakesScreenshot) DriverSingleton.getDriverInstance();
            File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(ImagesPath + ".png");
            FileUtils.copyFile(screenShotFile,destinationFile);
            setReportPassed("took ScreenShot Passed");
        }
        catch (Exception e){
            setReportFailed("took ScreenShot Failed");
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }
}
