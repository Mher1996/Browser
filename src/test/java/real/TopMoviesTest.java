package real;

import base.BaseTest;
import base.Helper;
import dataprovider.IndexDataProvider;
import objects.Movie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ImdbTop;
import pages.MovePage;
import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TopMoviesTest extends BaseTest {
    private List<String> moviesNames;
    private List<Double> moviesRatings;
    private List<Integer> moviesProductionYears;
    private List<WebElement> moviesLinks;
    private List<Movie> movieList;
    private Helper helper;


    @BeforeClass
    public void setUp() {
        getDriver().get("https://www.imdb.com/chart/top/");
        final ImdbTop topMovies = PageFactory.initElements(getDriver(), ImdbTop.class);
        moviesNames = topMovies.top250MoviesNames();
        moviesRatings = topMovies.movieRatings();
        moviesProductionYears = topMovies.movieProductionYears();
        moviesLinks = topMovies.getTopMoviesLinks();
        movieList=topMovies.getMovieObjects();
        helper = new Helper();
    }

    @Test(testName = "Movie name tester", dataProvider = "Indexes", dataProviderClass = IndexDataProvider.class)
    public void testMovieName(int index) {
        String path="C:\\Users\\Dell\\Desktop\\HomeWork\\";
        String fileName="screenshot.jpg";
        helper.screenShotAsh(getDriver(),path+fileName);
        helper.scrollIntoView(moviesLinks.get(index));
        helper.ctrlClick(getDriver(), moviesLinks.get(index));
        List<String> tab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tab.get(1));
        final MovePage movePage = PageFactory.initElements(getDriver(), MovePage.class);
        String movieName = movePage.getMovieName();
        getDriver().close();
        getDriver().switchTo().window(tab.get(0));


    }

    @Test(testName = "Overall test", dataProvider = "Indexes", dataProviderClass = IndexDataProvider.class)
    public void overallTest(int movieIndex) {
        helper.scrollIntoView(moviesLinks.get(movieIndex));
        helper.ctrlClick(getDriver(), moviesLinks.get(movieIndex));
        List<String> tab1 = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tab1.get(1));
        final MovePage movePage = PageFactory.initElements(getDriver(), MovePage.class);
        Movie movie =movePage.getMovieObject();

        getDriver().close();
        getDriver().switchTo().window(tab1.get(0));
        assertEquals(movieList.get(movieIndex), movie,"Hashcode should be same");




    }
    @AfterSuite
    public void tearDown(){
        getDriver().quit();
    }

}
