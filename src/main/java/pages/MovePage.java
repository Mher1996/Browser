package pages;

import objects.Movie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MovePage {
    private Movie movie;


    @FindBy(css = "[data-testid='hero-title-block__title']")
    private WebElement movieName;
    @FindBy(css = "[data-testid='hero-rating-bar__aggregate-rating__score'] [class^='AggregateRatingButton']")
    private List<WebElement> movesRating;
    @FindBy(css = "[data-testid='hero-title-block__metadata'] a")
    private List<WebElement> movieProductionYear;
    @FindBy(css = "[class^='AggregateRatingButton__RatingScore']")
    private List<WebElement> movieRatingInPage;





    public Movie getMovieObject(){
        return new Movie(getMovieName(),
                getMovieRating(),
                getMovieProductionYear());
    }
    public Double getMovieRatingInPage(){
        return Double.parseDouble(movieRatingInPage.get(0).getText());
    }

    public String getMovieName() {
        return movieName.getText();
    }

    public Double getMovieRating() {
        return Double.parseDouble(movesRating.get(0).getText());
    }
    public Integer getMovieProductionYear(){
        return Integer.parseInt(movieProductionYear.get(0).getText());
    }


}
