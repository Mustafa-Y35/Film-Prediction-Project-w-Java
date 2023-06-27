package com.example.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Algorithm {
    public static void moviePredict() {
        List<String> matchingFlags = new ArrayList<>();
        Utils utils = new Utils();
        Scanner input = new Scanner(System.in);

        CsvReader movieReader = new CsvReader();
        movieReader.readMoviesFromCSV("data/imdb_top_250.csv");
        List<Movie> movies = movieReader.getMovies();

        Movie randomMovie = movies.get(utils.getRandomNumberGenerator());
        UserPrediction user = new UserPrediction(movies);

        MovieChecker movieChecker = new MovieChecker(randomMovie);

        for (int i = 0; i < 5; i++) {
            System.out.println("Please enter a movie name: ");
            Movie userMovie = user.getUserPrediction(input.nextLine());

            if (userMovie == null) {
                System.out.println("Movie not found!");
            }
            else {
                movieChecker.checkMovie(userMovie);
                for (String flag : movieChecker.getMatchingFlags()) {
                    if (!matchingFlags.contains(flag)) {
                        System.out.println(flag);
                        matchingFlags.add(flag);
                    }
                }
                if (matchingFlags.contains("Title") && matchingFlags.contains("Year") && matchingFlags.contains("Genre") && matchingFlags.contains("Origin") && matchingFlags.contains("Director") && matchingFlags.contains("Star")) {
                    System.out.println("You won!");
                    break;
                }
            }
            if (i == 4) {
                System.out.println("You lost!");
                break;
            }
        }
        System.out.println("Title: " + randomMovie.getTitle()+
                "\nYear: " + randomMovie.getYear()+
                "\nGenre: " + randomMovie.getGenre()+
                "\nOrigin: " + randomMovie.getOrigin()+
                "\nDirector: " + randomMovie.getDirector()+
                "\nStar: " + randomMovie.getStar());

    }
}