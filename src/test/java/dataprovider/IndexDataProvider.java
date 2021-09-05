package dataprovider;

import org.testng.annotations.DataProvider;
import base.Helper;
import pages.CheckBoxPage;

public class IndexDataProvider {
    @DataProvider(name = "Indexes")
    public static Object[][] indexProvider(){
        Helper helper=new Helper();
        CheckBoxPage checkBoxPage=new CheckBoxPage();
        int bound=checkBoxPage.getAllOpenedChevrons().size();

        return helper.index(bound);
    }




  }
