package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyNewDriver {
    private static WebDriver webDriver;

    private static void setWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    public static   WebDriver getWebDriver() {
        if (webDriver==null) {
            setWebDriver();
        }
        return webDriver;
    }


}
