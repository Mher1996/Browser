import base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ImdbTop;

import java.util.ArrayList;
import java.util.List;

public class TopMoviesTest extends BaseTest {
    private List<String> moviesNames;
    private List<Double> moviesRatings;
    private List<Integer> moviesProductionYears;


    @BeforeMethod
    public void setUp() {
        getDriver().get("https://www.imdb.com/chart/top/");
        final ImdbTop topMovies = PageFactory.initElements(getDriver(), ImdbTop.class);
        moviesNames = topMovies.top250MoviesNames();
        moviesRatings = topMovies.movieRatings();
        moviesProductionYears = topMovies.movieProductionYears();


    }

    @Test(testName = "Top IMDB movies")
    public void topMoviesTest() {




    }

}
