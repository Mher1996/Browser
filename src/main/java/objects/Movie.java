package objects;

import java.util.Objects;

public class Movie {
    private final String movieName;
    private final Double movieRating;
    private final Integer movieProductionYear;

    public Movie(String movieName, Double movieRating, Integer movieProductionYear) {
        this.movieName = movieName;
        this.movieRating = movieRating;
        this.movieProductionYear = movieProductionYear;
    }

    public String getMovieName() {
        return movieName;
    }

    public Double getMovieRating() {
        return movieRating;
    }

    public Integer getMovieProductionYear() {
        return movieProductionYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie that = (Movie) o;
        return Objects.equals(movieName, that.movieName) && Objects.equals(movieRating, that.movieRating)
                && Objects.equals(movieProductionYear, that.movieProductionYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieName, movieRating, movieProductionYear);
    }
}
