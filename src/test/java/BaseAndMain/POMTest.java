package BaseAndMain;

import Screens.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POMTest {
    private static ExtentReports extent;
    private static ExtentSparkReporter htmlReporter;
    public static ExtentTest test;
    private Extras extras;
    private static WebDriver driver;

    @BeforeClass
    public void openWebsite(){
        extent = new ExtentReports();
        htmlReporter = new ExtentSparkReporter("C:\\Users\\user\\IdeaProjects\\BuyMeProject\\report.html");
        extent.attachReporter(htmlReporter);
        test = extent.createTest("BuyMeProject", "Project Reports");
        driver = DriverSingleton.getDriverInstance();
        driver.get(BasePage.getDataFromXML("URL"));
        extras = new Extras(driver);
    }

    @Test
    public void Test01_IntroAndRegScreen(){
        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.openRegistration();
        homeScreen.setDetails();
        homeScreen.confirmationCheck();
        homeScreen.registerationButton();
        homeScreen.priceDropDown();
        homeScreen.areaDropDown();
        homeScreen.categoryDropDown();
        homeScreen.searchButton();
    }

    @Test
    public void Test02_PickBusiness(){
        PickBusiness pickBusiness = new PickBusiness(driver);
        pickBusiness.URLAssertion();
        pickBusiness.pickBusiness();
        pickBusiness.amountInput();
        pickBusiness.clickChooseButton();
    }

    @Test
    public void Test03_SenderAndReceiverScreen(){
        SenderAndReceiverScreen senderAndReceiverScreen = new SenderAndReceiverScreen(driver);
        senderAndReceiverScreen.pressSomeoneElse();
        senderAndReceiverScreen.enterReceiveName();
        senderAndReceiverScreen.selectEvent();
        senderAndReceiverScreen.clearAndEnterBlessing();
        senderAndReceiverScreen.uploadPicture();
        senderAndReceiverScreen.continueButton();
        senderAndReceiverScreen.whenSendTheGift();
        senderAndReceiverScreen.sendGiftViaSMS();
        senderAndReceiverScreen.continueToPaymentButton();
    }

    @Test
    public void Test04_LoadingScreen_Bonus(){
        extras.gettingLoadingDotsSize();
    }

    @Test
    public void Test05_RedTextAssertion_Bonus(){
        extras.redTextAssertion_Bonus();
    }

    @Test
    public void Test06_ScrollDown_Bonus(){
        extras.scrollDownChooseGift_Bonus();
    }
    @Test
    public void Test07_PrintColorOfWhoSend_Bonus(){
        extras.getColorWhoSend_Bonus();
    }

    @AfterClass
    public void after(){
    extent.flush();
    }
}
