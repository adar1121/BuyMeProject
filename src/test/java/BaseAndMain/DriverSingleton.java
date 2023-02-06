package BaseAndMain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Screens.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.time.Duration;

public class DriverSingleton {
    static WebDriver driver;
    static WebDriverWait webDriverWait;

    public static WebDriver getDriverInstance() {
        String driverType = BasePage.getDataFromXML("browserType");
        if(driver == null && driverType.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Desktop\\Automation Course\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (driver == null && driverType.equalsIgnoreCase("ff")){
            System.setProperty("webdriver.firefox.driver", "C:\\Users\\user\\Desktop\\Automation Course\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static WebDriverWait getWebDriverWaitInstance(){
        if(webDriverWait==null){
            webDriverWait = new WebDriverWait(getDriverInstance(),Duration.ofSeconds(10));
        }
        return webDriverWait;
    }
}
