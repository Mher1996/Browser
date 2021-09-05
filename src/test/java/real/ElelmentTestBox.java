import base.BaseTest;
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
        final ElementsTextBox elementsTestBox = PageFactory.initElements(getDriver(), ElementsTextBox.class);
        elementsTestBox.setFullName(fullName);
        elementsTestBox.setEmail(email);
        elementsTestBox.setCurrentAdress(currentAdress);
        elementsTestBox.setPermanentAddress(pernamentAdress);
        elementsTestBox.setSubmit();
        elementsTestBox.scroolToOutput();
        assertEquals(fullName,elementsTestBox.getName());
    }

}
