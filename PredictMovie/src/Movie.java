public class Movie {
    private String no,title,year,genre,origin,director,star,link;

    public Movie(String no, String title, String year, String genre, String origin, String director, String star, String link) {
        this.no = no;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.origin = origin;
        this.director = director;
        this.star = star;
        this.link = link;
    }

    public String getNo() {
        return no;
    }

    public String getYear() {
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