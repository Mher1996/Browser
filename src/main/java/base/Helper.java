package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Helper {


    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) MyNewDriver.getWebDriver()).executeScript("arguments[0].scrollIntoView()", element);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ctrlClick(WebDriver driver, WebElement element) {
        final Actions action = new Actions(driver);
        action.keyDown(Keys.LEFT_CONTROL)
                .click(element).perform();
    }


    public Object[][] index(int bound) {
        Object[][] indexes = new Object[bound][1];
        for (int i = 0; i < bound; i++) {
            indexes[i][0] = i;

        }
        return indexes;
    }

    public void nativeScreenShot(WebDriver driver ,String filePath) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File fileDestination=new File(filePath);
        try {
            FileUtils.copyFile(screenShot,fileDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void screenShotAsh(WebDriver webDriver,String path){
        Screenshot screenAshot=new AShot().
                shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(webDriver);
        File ashFile=new File(path);
        try {
            ImageIO.write(screenAshot.getImage(),"jpg",ashFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void generateAlert(WebDriver driver, String alertText){
        ((JavascriptExecutor)driver).executeScript("alert('"+alertText+"')");
    }
    public void generatePrompt(WebDriver driver, String promptText,String inputPlaceHolder){
        ((JavascriptExecutor)driver).executeScript("alert('"+promptText+","+ inputPlaceHolder+"')");

    }

}

