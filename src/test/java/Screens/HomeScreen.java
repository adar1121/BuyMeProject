package Screens;

import BaseAndMain.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomeScreen extends BasePage {
    WebDriver driver;
    private WebDriverWait webDriverWait;
    private final String password = "Aa123456";
    private final String email = "adarm13@gmail.com";

    public HomeScreen(WebDriver driver){
        this.driver = driver;
    }

    // Open Register window at the Home Page
    public void openRegistration(){
        clickElement(By.xpath("//*[@id=\"ember1005\"]/div/ul[1]/li[3]/a/span"));
        By clickRegistration = By.className("text-link");
        waitForElementToBeClickable(clickRegistration);
        clickElement(clickRegistration);
    }

    // Enter details, name,Email,Password
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

    // check box to confirm the rules before registeration after filling the details
    public void confirmationCheck(){
        clickElement(By.className("fill"));
    }

    // click on register button
    public void registerationButton(){
        clickElement(By.cssSelector("button[type=submit]"));
    }


    // choose price from the dropdown
    public void priceDropDown(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        clickElement(By.className("selected-name"));
        waitForElementToBeClickable(By.id("ember1075"));
        clickElement(By.id("ember1075"));
    }

    // choose area from the dropdown
    public void areaDropDown(){
        clickElement(By.cssSelector("span[alt=אזור]"));
        clickElement(By.id("ember1111"));
    }

    // choose category from the dropdown
    public void categoryDropDown(){
        clickElement(By.cssSelector("span[alt=קטגוריה]"));
        clickElement(By.id("ember1174"));
    }

    // click search after filling filters
    public void searchButton(){
        clickElement(By.id("ember1199"));
    }
}
