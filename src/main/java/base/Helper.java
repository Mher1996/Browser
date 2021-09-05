package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Helper {
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
}

