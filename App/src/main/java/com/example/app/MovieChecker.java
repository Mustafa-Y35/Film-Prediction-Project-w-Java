package com.example.app;
import java.util.ArrayList;
import java.util.List;
public class MovieChecker {
    private Movie randomMovie;
    private boolean titleFlag;
    private boolean yearFlag;
    private boolean genreFlag;
    private boolean originFlag;
    private boolean directorFlag;
    private boolean starFlag;

    public MovieChecker(Movie randomMovie) {
        this.randomMovie = randomMovie;
        this.titleFlag = false;
        this.yearFlag = false;
        this.genreFlag = false;
        this.originFlag = false;
        this.directorFlag = false;
        this.starFlag = false;
    }

    public void checkMovie(Movie userMovie) {
        if (randomMovie.getTitle().equals(userMovie.getTitle())) {
            titleFlag = true;
        }
        if (randomMovie.getYear().equals(userMovie.getYear())) {
            yearFlag = true;
        }
        if (randomMovie.getGenre().equals(userMovie.getGenre())) {
            genreFlag = true;
        }
        if (randomMovie.getOrigin().equals(userMovie.getOrigin())) {
            originFlag = true;
        }
        if (randomMovie.getDirector().equals(userMovie.getDirector())) {
            directorFlag = true;
        }
        if (randomMovie.getStar().equals(userMovie.getStar())) {
            starFlag = true;
        }

    }

    public List<String> getMatchingFlags() {
        List<String> matchingFlags = new ArrayList<>();

        if (titleFlag) {
            matchingFlags.add("Title");
        }
        if (yearFlag) {
            matchingFlags.add("Year");
        }
        if (genreFlag) {
            matchingFlags.add("Genre");
        }
        if (originFlag) {
            matchingFlags.add("Origin");
        }
        if (directorFlag) {
            matchingFlags.add("Director");
        }
        if (starFlag) {
            matchingFlags.add("Star");
        }

        return matchingFlags;
    }


}
