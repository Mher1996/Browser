package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public WebDriver getDriver(){
        return MyNewDriver.getWebDriver();
    }
    public WebDriverWait getWait(){
        if (wait==null){
            wait=new WebDriverWait(webDriver,30,1000);
        }
        return  wait;
    }

    public WebElement waihForElement(WebElement webElement){
        return getWait().withMessage("Element cannot be located"+webElement).until(ExpectedConditions.visibilityOf(webElement));
    }




}
