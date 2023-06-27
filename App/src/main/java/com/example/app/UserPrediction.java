
package com.example.app;
import java.util.List;

public class UserPrediction{
    private List<Movie> movies;

    public UserPrediction (List<Movie> movies) {
        this.movies = movies;
    }

    public Movie getUserPrediction(String userPredict) {
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().equals(userPredict.toLowerCase())) {
                return movie;
            }

        }
        return null;
    }
}
