package real;

import base.BaseTest;
import base.Helper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.ElementsTextBox;
import static org.testng.Assert.*;

import java.util.UUID;

public class ElelmentTestBox extends BaseTest {
    @Test
    public void fillTextBoxes() {
        final String url = "https://demoqa.com/text-box";
        getDriver().navigate().to(url);
        final String fullName = "Sos Sargyan";
        final String email = "sos@mail.ru";
        final String currentAdress = "Republic";
        final String pernamentAdress = "lori"+ UUID.randomUUID().toString();
        final String alertMessage="Please handle this alert";
        final String promptMessage="Please handle this prompt";
        final String promptPlaceHolder="Simple place holder";
        final ElementsTextBox elementsTestBox = PageFactory.initElements(getDriver(), ElementsTextBox.class);
        elementsTestBox.setFullName(fullName);
        elementsTestBox.setEmail(email);
        elementsTestBox.setCurrentAdress(currentAdress);
        elementsTestBox.setPermanentAddress(pernamentAdress);
        Helper helper=new Helper();
        String path="C:\\Users\\Dell\\Desktop\\HomeWork\\";
        String fileName="Element.jpg";
       // helper.nativeScreenShot(getDriver(),path + fileName);
        helper.generateAlert(getDriver(),alertMessage);
        assertEquals(alertMessage,getDriver().switchTo().alert().getText());
        getDriver().switchTo().alert().accept();
        helper.generatePrompt(getDriver(),promptMessage,promptPlaceHolder);
        elementsTestBox.setSubmit();
        elementsTestBox.scroolToOutput();
        assertEquals(fullName,elementsTestBox.getName());
    }

}
