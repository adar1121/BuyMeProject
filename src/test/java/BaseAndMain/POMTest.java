package BaseAndMain;

import Screens.HomeScreen;
import Screens.LoadingScreen;
import Screens.PickBusiness;
import Screens.SenderAndReceiverScreen;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POMTest {

    private final String RealURL = "https://buyme.co.il/";
    private final String URL = "https://buyme.co.il/search?budget=1&category=16&region=13";
    static ExtentReports extent;
    static ExtentSparkReporter htmlReporter;
    static ExtentTest test;

    private static WebDriver driver;
    HomeScreen homeScreen;

    @BeforeClass
    public void openWebsite(){
        extent = new ExtentReports();
        htmlReporter = new ExtentSparkReporter("C:\\Users\\user\\IdeaProjects\\BuyMeProject\\report.html");
        extent.attachReporter(htmlReporter);
        test = extent.createTest("BuyMeProject", "Project Reports");
        driver = DriverSingleton.getDriverInstance();
        driver.get(BasePage.getDataFromXML("URL"));
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
        senderAndReceiverScreen.getColorWhoSend_Bonus();
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
    public void Test04_RedTextAssertion_Bonus(){
        homeScreen.redTextAssertion_Bonus();
    }

    @Test
    public void Test05_ScrollDown_Bonus(){
        homeScreen.scrollDownChooseGift_Bonus();
    }

    @Test
    public void Test05_LoadingScreen_Bonus(){
        LoadingScreen loadingScreen = new LoadingScreen(driver);
        loadingScreen.gettingLoadingDotsSize();
    }

    @AfterClass
    public void after(){
    extent.flush();
    }



}
