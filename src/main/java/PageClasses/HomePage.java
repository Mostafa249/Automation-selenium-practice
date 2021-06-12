package PageClasses;

import Utiliti.ActionsClass;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private static WebDriver driver;

    private static final By myAccountButton = By.xpath("//div[(@class='dropdown dropdown-login dropdown-tab')]");
    private static final By signUPButton = By.xpath("//a[(@class='dropdown-item tr')]");

    public static WebDriver getDriver() {
        return driver;
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on My account button then click on Signup button. ")
    public static void Homepage_Actions() {
        ActionsClass act = new ActionsClass(driver);
        act.Click(driver.findElement(myAccountButton));
        act.Click(driver.findElement(signUPButton));

    }
}
