package TestClasses;

import PageClasses.HomePage;
import PageClasses.SignupPage;

import Utiliti.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners(Utiliti.Listeners.class)
public class SignupTest {
    private final By welcomeMessage = By.xpath("//div[(@class='col-md-8')]");
    private static WebDriver driver;
    configFileReader config;

    @BeforeMethod(description = "Open the browser")
    public void Setup() throws IOException {
        config = new configFileReader();
        WebDriverManager.chromedriver().arch32().setup();
        driver = new ChromeDriver();
        Log.info("Now we open the browser.");
        driver.manage().window().maximize();
        Log.info("Browser is maximized now.");
        driver.get(config.getAwebUrl());
        Log.info("We Open The Website Now.");
        driver.manage().timeouts().implicitlyWait(config.getImplicitlyWait(), TimeUnit.SECONDS);
        HomePage hp = new HomePage(driver);
        SignupPage sp = new SignupPage(driver);
        Spreadsheet ss = new Spreadsheet("src/resource/PhpTravel-SignupData.xlsx", "Signup");
    }

    @Test(description = "Valid Signup ")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Signup with correct data")
    public void SignupTest1() throws IOException {
        HomePage.Homepage_Actions();
        String firstName = Spreadsheet.getData(1, 0);
        String lastName = Spreadsheet.getData(1, 1);
        String PhoneNumber = Spreadsheet.getData(1, 2);
        String email = Helper.CurrentTime("HHmmss") + Spreadsheet.getData(1, 3);
        String password = Spreadsheet.getData(1, 4);
        String confirmPassword = Spreadsheet.getData(1, 5);
        SignupPage.Signup_Actions(firstName, lastName, PhoneNumber, email, password, confirmPassword);
        String ExpectedResult = driver.findElement(welcomeMessage).getText();
        Log.info("Verifying signup successfully ");
        Assert.assertTrue(ExpectedResult.contains(firstName + " " + lastName));

    }

    @Test(dependsOnMethods = {"SignupTest1"}, description = "Valid Signup ")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Signup with correct data")
    public void SignupTest2() throws IOException {
        HomePage.Homepage_Actions();
        String firstName = Spreadsheet.getData(2, 0);
        String lastName = Spreadsheet.getData(2, 1);
        String PhoneNumber = Spreadsheet.getData(2, 2);
        String email = Helper.CurrentTime("HHmmss") + Spreadsheet.getData(2, 3);
        String password = Spreadsheet.getData(2, 4);
        String confirmPassword = Spreadsheet.getData(2, 5);
        SignupPage.Signup_Actions(firstName, lastName, PhoneNumber, email, password, confirmPassword);
        String ExpectedResult = driver.findElement(welcomeMessage).getText();
        Log.info("Verifying signup successfully ");
        Assert.assertTrue(ExpectedResult.contains(firstName + " " + lastName));

    }

    @AfterMethod(description = "Close the browser")
    public void tearDown() {
        driver.quit();
        Log.info("Now browser is closed ");
    }
}
