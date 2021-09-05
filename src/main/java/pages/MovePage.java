package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MovePage {
    @FindBy(css = "[data-testid='hero-title-block__title']")
    private WebElement movieName;
    @FindBy(css = "[data-testid='hero-rating-bar__aggregate-rating__score'] [class^='AggregateRatingButton']")
    private List<WebElement> movesRating;
    @FindBy(css = "[data-testid='hero-title-block__metadata'] a")
    private List<WebElement> moviePorductionYear;

    public String getMovieName() {
        return movieName.getText();
    }

    public Double getMovieRating() {
        return Double.parseDouble(movesRating.get(0).getText());
    }
    public Integer getMoviePorductionYear(){
        return Integer.parseInt(movesRating.get(0).getText());
    }

}
