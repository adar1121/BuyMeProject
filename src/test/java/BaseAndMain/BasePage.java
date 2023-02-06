package BaseAndMain;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;


public class BasePage {


    static WebDriverWait webDriverWait;




    public void waitForElementToBeClickable(By by){
        try {
            DriverSingleton.getWebDriverWaitInstance().until(ExpectedConditions.elementToBeClickable(by));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void setReportInfo(String info){
       POMTest.test.info(info);
    }
    public void setReportPassed(String details){
        POMTest.test.pass(details);
    }
    public void setReportFailed(String details){
        POMTest.test.log(Status.FAIL,details);
    }


    private static WebDriver driver;
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

    public void sendKeysToElement(By locator, String text){
        String timeNow = String.valueOf(System.currentTimeMillis());
        try {
            getWebElement(locator).sendKeys(text);
            setReportPassed("Passed");
        }
        catch (Exception e){
            setReportFailed("Failed");
            takeScreenShot(timeNow);
            System.out.println(e.getMessage());
        }
    }


    public void clickElement(By locator){
        String timeNow = String.valueOf(System.currentTimeMillis());
        try {
            getWebElement(locator).click();
            setReportPassed("Passed");
        }
        catch (Exception e){
            setReportFailed("Failed");
            takeScreenShot(timeNow);
            System.out.println(e.getMessage());
        }
    }

    public WebElement getWebElement(By locator){
        WebElement element = null;
        String timeNow = String.valueOf(System.currentTimeMillis());
        try {
            element = DriverSingleton.getDriverInstance().findElement(locator);
            setReportPassed("Passed");
        } catch (Exception e) {
            takeScreenShot(timeNow);
            setReportFailed("Failed");
            System.out.println(e.getMessage());
        }
        return element;
    }

//    public static void captureScreenShot(WebDriver driver,String screenShotName){
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//        try
//        {
//            FileUtils.copyFile(source,new File("TestFailed.png"));
//        }catch(Exception e)
//        {
//            System.out.println("exception");
//        }
//    }

    public String takeScreenShot(String ImagesPath){
        try{
            TakesScreenshot takesScreenshot = (TakesScreenshot) DriverSingleton.getDriverInstance();
            File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(ImagesPath + ".png");
            FileUtils.copyFile(screenShotFile,destinationFile);
            setReportPassed("Passed");
        }
        catch (Exception e){

        }
        return ImagesPath + ".png";
    }


}
