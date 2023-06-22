import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private List<Movie> movies;

    public CsvReader() {
        movies = new ArrayList<>();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void readMoviesFromCSV(String csvFile) {
        String line;
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] movieData = line.split(csvSplitBy);
                if (movieData.length == 8) {
                    String no = movieData[0];
                    String title = movieData[1];
                    String year = movieData[2];
                    String genre = movieData[3];
                    String origin = movieData[4];
                    String director = movieData[5];
                    String star = movieData[6];
                    String imdbLink = movieData[7];

                    Movie movie = new Movie(no, title, year, genre, origin, director, star, imdbLink);
                    movies.add(movie);
                } else {
                    System.out.println("Hatalı satır: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




