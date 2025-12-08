//import java.util.Stack;
import java.util.HashMap;

public class Stack {

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

    private Stack<Transaction> history;

    public Stack() {
        history = new Stack<>();
    }

    /** Adds a new transaction to the stack. */
    public void pushTransaction(String movieName, double price) {
        history.push(new Transaction(movieName, price));
    }

    /** Removes and returns the latest transaction. */
    public Transaction popTransaction() {
        if (history.isEmpty()) return null;
        return history.pop();
    }

    /** Returns the most recent transaction without removing it. */
    public Transaction peekTransaction() {
        if (history.isEmpty()) return null;
        return history.peek();
    }

    /** Returns number of transactions stored. */
    public int getTransactionCount() {
        return history.size();
    }

    /** Creates a ranking (movieName -> number of purchases). */
    public HashMap<String, Integer> generateMovieRanking() {
        HashMap<String, Integer> ranking = new HashMap<>();

        for (Transaction t : history) {
            ranking.put(t.getMovieName(), ranking.getOrDefault(t.getMovieName(), 0) + 1);
        }

        return ranking;
    }

    /** True if no transactions exist. */
    public boolean isEmpty() {
        return history.isEmpty();
    }
}