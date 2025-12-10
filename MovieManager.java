package model;

import java.util.HashMap;

public class MovieManager {

    private HashMap<String, Movie> movies;

    public MovieManager() {
        movies = new HashMap<>();
    }

    /**
     * Adds a movie with a title and ticket price.
     */
    public void addMovie(String title, double price) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Ticket price cannot be negative.");
        }

        movies.put(title, new Movie(title, price));
    }

    /**
     * Sells exactly one ticket for the given movie.
     */
    public void sellTicket(String title) {
        Movie m = movies.get(title);
        if (m != null) {
            m.sellOne();
        } else {
            System.out.println("Movie not found: " + title);
        }
    }

    /**
     * Gets total revenue of one movie.
     */
    public double getRevenue(String title) {
        Movie m = movies.get(title);
        return (m == null) ? 0.0 : m.getRevenue();
    }

    /**
     * Returns the Movie object with the highest revenue.
     */
    public Movie getMostProfitableMovie() {
        Movie most = null;

        for (Movie m : movies.values()) {
            if (most == null || m.getRevenue() > most.getRevenue()) {
                most = m;
            }
        }

        return most;
    }

    /**
     * Returns the HashMap for iteration or display.
     */
    public HashMap<String, Movie> getAllMovies() {
        return movies;
    }

    /**
     * Calculates total revenue across all movies.
     */
    public double getTotalRevenue() {
        double total = 0;
        for (Movie m : movies.values()) {
            total += m.getRevenue();
        }
        return total;
    }

    /**
     * Prints a formatted summary of all movie stats.
     */
    public void printMovieReport() {
        System.out.println("\n=== Movie Sales Report ===");
        for (Movie m : movies.values()) {
            System.out.println(
                m.getTitle() + " | Price: $" + m.getPrice() +
                " | Sold: " + m.getTicketsSold() +
                " | Revenue: $" + m.getRevenue()
            );
        }
        System.out.println("Total Revenue: $" + getTotalRevenue());
    }
}
