package Screens;

import BaseAndMain.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class HomeScreen extends BasePage {
    WebDriver driver;
    private WebDriverWait webDriverWait;

    private final String password = "Aa123456";
    private final String email = "adarm13@gmail.com";
    private Select select;

    public HomeScreen(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        setReportInfo("set HomeScreen driver Pass");
    }
    public void scrollDownChooseGift_Bonus(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(867,3515)");
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source,new File("ScrollDown.png"));
            setReportPassed("Scroll down bonus Passed");
        } catch (IOException e) {
            setReportFailed("Scroll down bonus Failed");
        }
    }


    public void redTextAssertion_Bonus(){
        String redText = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
        clickElement(By.className("notSigned"));
        By loginToBuyMe = By.id("ember1852");
        waitForElementToBeClickable(loginToBuyMe);
        clickElement(loginToBuyMe);
        Assert.assertEquals(driver.findElement(By.className("parsley-required")).getText(),redText);
    }

    public void openRegistration(){
        clickElement(By.xpath("//*[@id=\"ember1005\"]/div/ul[1]/li[3]/a/span"));
        By clickRegistration = By.className("text-link");
        waitForElementToBeClickable(clickRegistration);
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(clickRegistration));
        clickElement(clickRegistration);
    }

    public void setDetails(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try{
            driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.cssSelector("input[placeholder=מייל]"))).sendKeys(Constants.firstName); // back
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        sendKeysToElement(By.cssSelector("input[placeholder=מייל]"),email);
        sendKeysToElement(By.cssSelector("input[placeholder=סיסמה]"),password);
        sendKeysToElement(By.id("ember1883"),password);
    }

    public void confirmationCheck(){
        clickElement(By.className("fill"));
    }

    public void registerationButton(){
        clickElement(By.cssSelector("button[type=submit]"));
    }


    public void priceDropDown(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        clickElement(By.className("selected-name"));
        waitForElementToBeClickable(By.id("ember1075"));
        clickElement(By.id("ember1075"));
    }

    public void areaDropDown(){
        clickElement(By.cssSelector("span[alt=אזור]"));
        clickElement(By.id("ember1111"));
    }

    public void categoryDropDown(){
        clickElement(By.cssSelector("span[alt=קטגוריה]"));
        clickElement(By.id("ember1174"));
    }

    public void searchButton(){
        clickElement(By.id("ember1199"));
    }
}
