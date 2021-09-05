package real;

import base.BaseTest;
import dataprovider.IndexDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

import java.util.List;

import static org.testng.Assert.*;

public class CheckBoxTest extends BaseTest {
    private CheckBoxPage checkBoxPage;
    private List<WebElement> checkBoxes;
    private List<WebElement> openChevrons;
    private List<WebElement> closeChevrons;
    private WebElement expandAll;
    private WebElement collapseAll;
    private WebElement home;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        String url = "https://demoqa.com/checkbox";
        getDriver().get(url);
        checkBoxPage = PageFactory.initElements(getDriver(), CheckBoxPage.class);
        checkBoxes = checkBoxPage.getCheckBoxes();
        openChevrons = checkBoxPage.getAllOpenedChevrons();
        closeChevrons = checkBoxPage.getClosedChevrons();
        expandAll = checkBoxPage.getExpandAll();
        collapseAll = checkBoxPage.getCollapseAll();
        home = checkBoxPage.getHome();
    }


    @Test(testName = "Expanded subsections")
    public void CheckBoxTest() {
        expandAll.click();
        for (WebElement element : openChevrons) {
            assertTrue(element.getAttribute("class").contains("rct-icon-expand-open"));
        }
    }

    @Test(testName = "Collapsed subsections")
    public void checkCollapsed() {
        collapseAll.click();
        for (WebElement element : closeChevrons)
            assertTrue(element.getAttribute("class").contains("rct-icon-expand-close"));
    }

    @Test(testName = "All Check boxes ")
    public void checkBoxTest() {
        expandAll.click();
        checkBoxes.get(0).click();
        collapseAll.click();
        assertTrue(checkBoxes.get(0).getAttribute("class").contains("-check"));
    }

    @Test(testName = "Home check box")
    public void homeCheckBoxTest() {
        closeChevrons.get(0).click();
        for (int i = 1; i < checkBoxes.size(); i++) {
            checkBoxes.get(i).click();
            assertTrue(checkBoxes.get(0).getAttribute("class").contains("half-check"));
            checkBoxes.get(i).click();
        }

    }


    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }
}
