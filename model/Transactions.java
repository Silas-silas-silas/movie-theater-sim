package model;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Transactions {

    //Represents a ticket purchase transaction/
    private class Transaction {
        private String movieName;
        private double price;

        public Transaction(String movieName, double price) {
            this.movieName = movieName;
            this.price = price;
        }

        public String getMovieName() {
            return movieName;
        }

        public double getPrice() {
            return price;
        }
    }

    //Represents available movie information
    public static class MovieInfo {
        private String name;
        private String showtime;
        private double ticketPrice;
        private String genre;
        private int runtimeMinutes;

        public MovieInfo(String name, String showtime, double ticketPrice, String genre, int runtimeMinutes) {
            this.name = name;
            this.showtime = showtime;
            this.ticketPrice = ticketPrice;
            this.genre = genre;
            this.runtimeMinutes = runtimeMinutes;
        }

        public String getName() {
            return name;
        }

        public String getShowtime() {
            return showtime;
        }

        public double getTicketPrice() {
            return ticketPrice;
        }

        public String getGenre() {
            return genre;
        }

        public int getRuntimeMinutes() {
            return runtimeMinutes;
        }

        @Override
        public String toString() {
            return "Movie: " + name +
                   "\nShowtime: " + showtime +
                   "\nTicket Price: $" + ticketPrice +
                   "\nGenre: " + genre +
                   "\nRuntime: " + runtimeMinutes + " minutes";
        }
    }

    private Stack<Transaction> history;
    private Map<String, MovieInfo> movies;   // stores all movie details

    //CONSTRUCTOR

    public Transactions() {
        history = new Stack<>();
        movies = new HashMap<>();
    }

    //MOVIE INFO METHOD/

    //Adds a movie to the catalog
    public void addMovie(String name, String showtime, double ticketPrice, String genre, int runtimeMinutes) {
        movies.put(name, new MovieInfo(name, showtime, ticketPrice, genre, runtimeMinutes));
    }

    //Returns a MovieInfo object if the movie exists
    public MovieInfo getMovieInfo(String movieName) {
        return movies.get(movieName);
    }

    //Returns all available movies.
    public Map<String, MovieInfo> getAllMovies() {
        return movies;
    }

    //Simple "select a movie" lookup (used by CLI in the main program)
    public MovieInfo selectMovie(String movieName) {
        return movies.get(movieName);
    }

    //TRANSACTION METHODS

    // Adds a new transaction to the stack.
    public void pushTransaction(String movieName, double price) {
        history.push(new Transaction(movieName, price));
    }

    // Removes and returns the latest transaction.
    public Transaction popTransaction() {
        if (history.isEmpty()) return null;
        return history.pop();
    }

    //Returns the most recent transaction without removing it
    public Transaction peekTransaction() {
        if (history.isEmpty()) return null;
        return history.peek();
    }

    //Returns number of transactions stored.
    public int getTransactionCount() {
        return history.size();
    }

    //Creates a ranking (movieName -> number of purchases)
    public HashMap<String, Integer> generateMovieRanking() {
        HashMap<String, Integer> ranking = new HashMap<>();

        for (Transaction t : history) {
            ranking.put(t.getMovieName(), ranking.getOrDefault(t.getMovieName(), 0) + 1);
        }

        return ranking;
    }

    //True if no transactions exist.
    public boolean isEmpty() {
        return history.isEmpty();
    }
}