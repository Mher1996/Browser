package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxPage {
    @FindBy(css = "[class='rct-title']" )
    private WebElement home;
    @FindBy(css = "[class='rct-icon rct-icon-expand-close']")
    private List<WebElement> chevronClose;
    @FindBy(css = "[class='rct-icon rct-icon-expand-all'] ")
    private WebElement expandAll;
    @FindBy(css = "[class='rct-icon rct-icon-collapse-all']")
    private WebElement collapseAll;
    @FindBy(css = "[class='rct-icon rct-icon-expand-open']")
    private List<WebElement> chevronOpen;
    @FindBy(css = "[class='rct-checkbox'] svg")
    private List<WebElement> checkBoxes;

    public List<WebElement> getCheckBoxes(){
        return checkBoxes;
    }

    public List<WebElement> getAllOpenedChevrons(){
        return chevronOpen;
    }

    public List<WebElement> getClosedChevrons(){
        return chevronClose;
    }

    public WebElement getHome() {
        return home;
    }
    public WebElement getExpandAll(){
        return expandAll;
    }
    public WebElement getCollapseAll(){
        return collapseAll;
    }
}
