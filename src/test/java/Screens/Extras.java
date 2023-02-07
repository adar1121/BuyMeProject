package Screens;

import BaseAndMain.BasePage;
import BaseAndMain.DriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Extras extends BasePage {
    private WebDriver driver;
    private final String URL = "https://buyme.co.il/";
    private WebDriverWait webDriverWait;

    public Extras (WebDriver driver){
        this.driver = driver;
        webDriverWait = DriverSingleton.getWebDriverWaitInstance();
    }

    public void gettingLoadingDotsSize(){
        try{
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
            driver.get(URL);
        }catch (Exception e){
            By middleDot = By.className("bounce2");
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(middleDot));
            System.out.println("height of middle dot is: "+ getWebElement(middleDot).getSize().height);
            System.out.println("width of middle dot is: "+ getWebElement(middleDot).getSize().width);
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

    public void scrollDownChooseGift_Bonus(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(867,3515)");
        try {
            takeScreenShot("ScrollDown");
            setReportPassed("Scroll down bonus Passed");
        } catch (Exception e) {
            setReportFailed("Scroll down bonus Failed");
        }
    }

    public void getColorWhoSend_Bonus(){
        String color = getWebElement(By.className("label")).getCssValue("color");
        System.out.println(Color.fromString(color).asHex());
    }
}
