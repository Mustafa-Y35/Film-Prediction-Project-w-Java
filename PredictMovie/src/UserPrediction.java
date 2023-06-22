import java.util.List;

public class UserPrediction{
    private List<Movie> movies;

    public UserPrediction (List<Movie> movies) {
        this.movies = movies;
    }

    public Movie getUserPrediction(String user_predict) {
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().equals(user_predict.toLowerCase())) {
                return movie;
            }

        }
        return null;
    }
}
