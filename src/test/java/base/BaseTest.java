package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.util.UUID;

public abstract class BaseTest {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return MyNewDriver.getWebDriver();
    }

    public WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(webDriver, 30, 1000);
        }
        return wait;
    }

    public WebElement waihForElement(WebElement webElement) {
        return getWait().withMessage("Element cannot be located" + webElement).until(ExpectedConditions.visibilityOf(webElement));
    }

    @AfterMethod(alwaysRun = true)
    public void methodTearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Helper helper = new Helper();
            String filePath = "C:\\Users\\Dell\\Desktop\\HomeWork\\";
            String name = UUID.randomUUID() + ".jpg";
            helper.nativeScreenShot(getDriver(), filePath + name);

        }


    }
}
