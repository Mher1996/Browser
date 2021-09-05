package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IMDBmoviePage {
    @FindBy(css = "[data-testid='hero-rating-bar__aggregate-rating__score'] [class='AggregateRatingButton']")
    private List<WebElement>movieRating;

    public Double getMovieRatingFromPage(){
        return Double.parseDouble(movieRating.get(0).getText()) ;
    }

}
