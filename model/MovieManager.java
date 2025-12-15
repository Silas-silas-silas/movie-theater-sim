package model;

import java.util.HashMap;

public class MovieManager {

    private HashMap<String, Movie> movies;

    public MovieManager() {
        movies = new HashMap<>();
    }

    public void addMovie(String title, double price) {
        movies.put(title, new Movie(title, price));
    }

    public void sellTicket(String title) {
        Movie m = movies.get(title);
        if (m != null) {
            m.sellOne();
        }
    }

    public Movie getMostPopularMovie() {
        Movie most = null;

        for (Movie m : movies.values()) {
            if (most == null || m.getTicketsSold() > most.getTicketsSold()) {
                most = m;
            }
        }
        return most;
    }

    public HashMap<String, Movie> getAllMovies() {
        return movies;
    }

    public void printMovieReport() {
        System.out.println("\n=== Movie Attendance Report ===");
        for (Movie m : movies.values()) {
            System.out.println(
                m.getTitle() +
                " | Price: $" + m.getPrice() +
                " | Tickets Sold: " + m.getTicketsSold()
            );
        }
    }
}

