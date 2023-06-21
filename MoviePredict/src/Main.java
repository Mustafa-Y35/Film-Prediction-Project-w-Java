import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        String csvFile = "dosya.csv";
        String line;
        String csvSplitBy = ";";

        List<Movie> movies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] movieData = line.split(csvSplitBy);
                if (movieData.length == 8) {
                    int no = Integer.parseInt(movieData[0]);
                    String title = movieData[1];
                    int year = Integer.parseInt(movieData[2]);
                    String genre = movieData[3];
                    String origin = movieData[4];
                    String director = movieData[5];
                    String star = movieData[6];
                    String imdbLink = movieData[7];

                    Movie movie = new Movie(no, title,year, genre, origin, director, star, imdbLink);
                    movies.add(movie);
                } else {
                    System.out.println("Hatalı satır: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Depolanan verilerle ilgili işlemleri burada yapabilirsiniz
        for (Movie movie : movies) {
            System.out.println(movie.getTitle());
        }
    }
}
class Movie {
    private int no,year;
    private String title,genre,origin,director,star,link;

    public Movie(int no, int year, String title, String genre, String origin, String director, String star, String link) {
        this.no = no;
        this.year = year;
        this.title = title;
        this.genre = genre;
        this.origin = origin;
        this.director = director;
        this.star = star;
        this.link = link;
    }

    public int getNo() {
        return no;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDirector() {
        return director;
    }

    public String getStar() {
        return star;
    }

    public String getLink() {
        return link;
    }
}
