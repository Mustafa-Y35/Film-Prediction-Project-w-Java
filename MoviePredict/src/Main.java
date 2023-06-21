import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        String csvFile = "C:\\Users\\musta\\OneDrive\\Belgeler\\GitHub\\proje\\MoviePredict\\src\\imdb_top_250.csv";
        String line;
        String csvSplitBy = ";";

        List<Movie> movies = new ArrayList<>();

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

                    Movie movie = new Movie(no,title,year,genre,origin,director,star,imdbLink);
                    movies.add(movie);
                } else {
                    System.out.println("Hatalı satır: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Movie movie : movies) {
            System.out.println(movie.getNo());
            System.out.println(movie.getTitle());
            System.out.println(movie.getYear());
            System.out.println(movie.getGenre());
            System.out.println(movie.getOrigin());
            System.out.println(movie.getDirector());
            System.out.println(movie.getStar());
            System.out.println(movie.getLink());
        }

        System.out.println("\n");

        int lineNumber = 0;

        try {
            FileReader fileReader = new FileReader(csvFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((bufferedReader.readLine()) != null) {
                lineNumber++;
            }

            Random random = new Random();
            int randomLineNumber = random.nextInt(lineNumber);

            fileReader = new FileReader(csvFile);
            bufferedReader = new BufferedReader(fileReader);
            lineNumber = 0;

            while ((line = bufferedReader.readLine()) != null) {
                if (lineNumber == randomLineNumber) {
                    System.out.println(line);
                    break;
                }
                lineNumber++;
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

