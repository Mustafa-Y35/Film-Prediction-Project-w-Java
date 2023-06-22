import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Utils utils  = new Utils();
        Scanner input = new Scanner(System.in);
        CsvReader movieReader = new CsvReader();

        movieReader.readMoviesFromCSV("data/imdb_top_250.csv");
        List<Movie> movies = movieReader.getMovies();




    }
}
