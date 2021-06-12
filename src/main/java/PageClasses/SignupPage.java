package PageClasses;

import Utiliti.ActionsClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private static WebDriver driver;
    private static final By firstnameField = By.name("firstname");
    private static final By lastnameField = By.name("lastname");
    private static final By mobilenumberField = By.name("phone");
    private static final By mailField = By.name("email");
    private static final By passwordField = By.name("password");
    private static final By confirmpasswordField = By.name("confirmpassword");
    private static final By SignUpButton = By.xpath("//button[@type='submit']");

    public SignupPage(WebDriver driver) {
        SignupPage.driver = driver;
    }


    @Step("Signup with first name :{firstname},last name :{lastname},phone:{phone},email:{email},password:{password},confirmpassword:{confirmPassword},for method:{SignupTest}")
    public static void Signup_Actions(String firstname, String lastname, String phone,
                                      String email, String password, String confirmPassword) {
        ActionsClass act = new ActionsClass(driver);
        act.SendKeys(driver.findElement(firstnameField), firstname);
        act.SendKeys(driver.findElement(lastnameField), lastname);
        act.SendKeys(driver.findElement(mobilenumberField), phone);
        act.SendKeys(driver.findElement(mailField), email);
        act.SendKeys(driver.findElement(passwordField), password);
        act.SendKeys(driver.findElement(confirmpasswordField), confirmPassword);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(SignUpButton));
            act.Click(driver.findElement(SignUpButton));
    }
}
