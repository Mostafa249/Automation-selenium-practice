package Utiliti;

import PageClasses.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
public class ActionsClass {
    private WebDriver driver;
    public ActionsClass(WebDriver driver){
        this.driver= driver;
    }
    public void Click(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        Log.info("Clcik on " + element);
    }

    public void SendKeys(WebElement element,String text) {
        Actions actions = new Actions(driver);
        actions.sendKeys(element,text).perform();
        Log.info("put "+text+" in the elment "+element);
    }


}
