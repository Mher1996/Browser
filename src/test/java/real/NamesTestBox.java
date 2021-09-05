import base.BaseTest;
import dataprovider.IndexDataProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Helper;
import pages.ImdbTop;
import pages.MovePage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class NamesTestBox extends BaseTest {
    private List<String> moviesNames;
    private List<WebElement> movieLinks;
    private ImdbTop moviesListPage;
    private MovePage movePage;
    private Helper helper;


    @BeforeClass
    public void setUp() {
        getDriver().get("https://www.imdb.com/chart/top/");
        moviesListPage = PageFactory.initElements(getDriver(), ImdbTop.class);
        moviesNames = moviesListPage.top250MoviesNames();
        movieLinks = moviesListPage.grtTopMoviesLinks();
        helper = new Helper();
    }

    @Test(testName = "NamesTest", dataProvider = "Indexes", dataProviderClass = IndexDataProvider.class)
    public void topMoviesTest(int index) {
        WebElement movieLink = movieLinks.get(index);
        helper.ctrlClick(getDriver(), movieLink);
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        movePage = PageFactory.initElements(getDriver(), MovePage.class);
        String movieName = movePage.getMovieName();
        getDriver().close();
        getDriver().switchTo().window(tabs.get(0));

        assertEquals(movieName, moviesNames.get(index));
    }
    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        getDriver().quit();
    }

}
