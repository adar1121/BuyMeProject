package Screens;
import BaseAndMain.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SenderAndReceiverScreen extends BasePage {
    private final String phoneNumberToSendSMS = "521234567";
    private final String phoneNumber = "541234567";
    private final String blessingText = "Happy Birthday";
    private final String receiverName = "Dudi";
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor js;

    public SenderAndReceiverScreen(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void getColorWhoSend_Bonus(){
        String color = getWebElement(By.className("label")).getCssValue("color");
        System.out.println(Color.fromString(color).asHex());
    }

    public void pressSomeoneElse(){
        clickElement(By.id("ember1940"));
    }

    public void enterReceiveName(){
        sendKeysToElement(By.id("ember1944"),receiverName);
    }

    public void selectEvent(){
        clickElement(By.className("selected-name"));

        try{
            js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('ember2049').click()");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void clearAndEnterBlessing(){
        By blessingBox = By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/form/div[2]/div[4]/label/textarea");
        getWebElement(blessingBox).clear();
        sendKeysToElement(blessingBox,blessingText);
    }

    public void uploadPicture(){
        sendKeysToElement(By.id("ember1963"),"C:\\Users\\user\\Desktop\\picture.png");
    }

    public void continueButton(){
        clickElement(By.cssSelector("button[gtm=המשך]"));
    }

    public void whenSendTheGift(){
        try{
            js.executeScript("document.getElementById('ember2087').click()");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void sendGiftViaSMS(){
        clickElement(By.cssSelector("svg[gtm=method-sms]"));
        sendKeysToElement(By.cssSelector("input[data-parsley-mobile=mobile]"),"0"+ phoneNumberToSendSMS);
        sendKeysToElement(By.id("ember2116"), Constants.firstName);
        sendKeysToElement(By.id("ember2137"),"0" + phoneNumber);
    }

    public void continueToPaymentButton(){
        clickElement(By.cssSelector("button[type=submit]"));
    }
}
