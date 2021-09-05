package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImdbTop {
    @FindBy(css = "[class='lister-list'] tr")
    private List<WebElement> top250Films;

    @FindBy(css = "[class='ratingColumn imdbRating']")
    private List<WebElement> top250FilmsRatings;


    public List<String> top250MoviesNames() {
        List<String> moviesNames = new ArrayList<>();
        for (WebElement movie : top250Films) {
            String movieName = movie.getText().split("[.]")[1];
            movieName = movieName.split("[(]")[0];
            moviesNames.add(movieName.strip());
        }
        return moviesNames;
    }

    public List<Double> movieRatings() {
        List<Double> ratings = new ArrayList<>();
        for (WebElement rating : top250FilmsRatings) {
            ratings.add(Double.parseDouble(rating.getText()));
        }
        return ratings;
    }

    public Map<String, Double> movieRatingMap() {
        Map<String, Double> movieRating = new HashMap<>();
        List<String> top250MoviesNames = top250MoviesNames();
        List<Double> ratings = movieRatings();
        for (int i = 0; i < ratings.size(); i++) {
            movieRating.put(top250MoviesNames.get(i), ratings.get(i));
        }
        return movieRating;
    }

    public List<Integer> movieProductionYears() {
        List<Integer> years = new ArrayList<>();
        for (WebElement element : top250Films) {
            String year = element.getText().split("[(]")[1];
            year = year.split("[)]")[0];
            years.add(Integer.parseInt(year));
        }
        return years;
    }


}

