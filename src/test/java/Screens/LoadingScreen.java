package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoadingScreen {
    private WebDriver driver;
    private final String URL = "https://buyme.co.il/";
    private WebDriverWait webDriverWait;

    public LoadingScreen (WebDriver driver){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    public void gettingLoadingDotsSize(){
        try{
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
            driver.get(URL);
        }catch (Exception e){
            By middleDot = By.className("bounce265");
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(middleDot));
            System.out.println("height of middle dot is: "+ driver.findElement(middleDot).getSize().height);
            System.out.println("width of middle dot is: "+ driver.findElement(middleDot).getSize().width);
        }
    }
}
