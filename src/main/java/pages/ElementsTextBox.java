package pages;

import base.MyNewDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsTextBox {
    @FindBy(css ="[id='userName']" )
    private WebElement fullName;
    @FindBy(css = "[id='userEmail']")
    private WebElement email;
    @FindBy(css = "[id='currentAddress']")
    private WebElement currentAdress;
    @FindBy(css = "[id='permanentAddress']")
    private WebElement permanentAddress;
    @FindBy(css = "[id='submit']")
    private WebElement submit;

    //---------------------------
   @FindBy(css = "[id='output']")
   private WebElement output;
    @FindBy(css = "[id='name']")
    private WebElement nameOutput;
    @FindBy(css ="[id='email']" )
    private WebElement emailOutput;
    @FindBy(css = "[id='currentAddress']")
    private WebElement currentAddressOutput;
    @FindBy(css ="[id='permanentAddress']" )
    private WebElement permanentAddressOutput;

    public void scrollIntoView(WebElement element){
        ((JavascriptExecutor) MyNewDriver.getWebDriver()).executeScript("arguments[0].scrollIntoView()",element);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setFullName(String fullNameText){
        scrollIntoView(fullName);
        fullName.click();
        fullName.sendKeys(fullNameText);

    }
    public void setEmail(String emailText){
        scrollIntoView(email);
        email.click();
        email.sendKeys(emailText);
    }
    public void setCurrentAdress(String currentAdressText){
        scrollIntoView(currentAdress);
        currentAdress.click();
        currentAdress.sendKeys(currentAdressText);
    }
    public void setPermanentAddress(String permanentAddressText){
        scrollIntoView(permanentAddress);
        permanentAddress.click();
        permanentAddress.sendKeys(permanentAddressText);
    }
    public void setSubmit(){
        scrollIntoView(submit);
        submit.click();
    }

    public String getInputFieldPlaceHolder(WebElement inputElement){
        scrollIntoView(inputElement);
        return inputElement.getAttribute("placeholder");

    }
        public boolean isEmailErrorDisplayed(){
        scrollIntoView(email);
        return  email.getAttribute("class").contains("field-error");
        }
        public void scroolToOutput(){
        scrollIntoView(output);
        }
        public String getName(){
        return nameOutput.getText().split(":")[1];
        }

    }


