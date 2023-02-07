package Screens;

import BaseAndMain.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SenderAndReceiverScreen extends BasePage {
    private final String phoneNumberToSendSMS = "521234567";
    private final String phoneNumber = "541234567";
    private final String blessingText = "Happy Birthday";
    private final String receiverName = "Dudi";
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor js;

    // set driver
    public SenderAndReceiverScreen(WebDriver driver){
        this.driver = driver;
    }

    // press on someone else button
    public void pressSomeoneElse(){
        clickElement(By.id("ember1940"));
    }

    // enter receiver name
    public void enterReceiveName(){
        sendKeysToElement(By.id("ember1944"),receiverName);
    }

    // select an event from dropdown
    public void selectEvent(){
        clickElement(By.className("selected-name"));
        try{
            js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('ember2049').click()");
            setReportPassed("Choose event successfully");
        }catch (Exception e){
            System.out.println(e.getMessage());
            setReportFailed("Failed to choose an event");
        }
    }

    // clear and entering blessing
    public void clearAndEnterBlessing(){
        By blessingBox = By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/form/div[2]/div[4]/label/textarea");
        getWebElement(blessingBox).clear();
        sendKeysToElement(blessingBox,blessingText);
    }

    // upload a picture
    public void uploadPicture(){
        sendKeysToElement(By.id("ember1963"),"C:\\Users\\user\\Desktop\\picture.png");
    }

    // click on continue button for next page
    public void continueButton(){
        clickElement(By.cssSelector("button[gtm=המשך]"));
    }

    // choose send now the gift
    public void whenSendTheGift(){
        try{
            js.executeScript("document.getElementById('ember2087').click()");
            setReportPassed("send the gift Now Passed");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            setReportFailed("Failed to click on Now");
        }
    }

    // Choose to Send the gift Via SMS and entering details
    public void sendGiftViaSMS(){
        clickElement(By.cssSelector("svg[gtm=method-sms]"));
        sendKeysToElement(By.cssSelector("input[data-parsley-mobile=mobile]"),"0"+ phoneNumberToSendSMS);
        sendKeysToElement(By.id("ember2116"), Constants.firstName);
        sendKeysToElement(By.id("ember2137"),"0" + phoneNumber);
        setReportPassed("Set details for send gift via SMS Passed");
    }

    public void continueToPaymentButton(){
        clickElement(By.cssSelector("button[type=submit]"));
    }
}
