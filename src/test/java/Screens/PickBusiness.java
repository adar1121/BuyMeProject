package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import BaseAndMain.*;
import java.time.Duration;

public class PickBusiness extends BasePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private final String amount = "200";
    private final String searchURL = "https://buyme.co.il/search?budget=1&category=16&region=13";

    public PickBusiness(WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void URLAssertion(){
        Assert.assertEquals(driver.getCurrentUrl(), searchURL);
    }

    public void pickBusiness(){
        By businessChooseClick = By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/ul/div[2]/a/div/div[3]");
        waitForElementToBeClickable(businessChooseClick);
        clickElement(businessChooseClick);
    }
    public void amountInput(){
        waitForElementToBeClickable(By.id("ember1820"));
        sendKeysToElement(By.id("ember1814"),amount);
    }
    public void clickChooseButton(){
        clickElement(By.id("ember1821"));
    }
}
