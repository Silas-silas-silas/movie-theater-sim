package model;

import java.util.Stack;

public class Transactions {

    private static class Transaction {
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

    public Transactions() {
        history = new Stack<>();
    }

    public void logSale(String movieName, double price) {
        history.push(new Transaction(movieName, price));
    }

    public double getTotalRevenue() {
        double total = 0;
        for (Transaction t : history) {
            total += t.getPrice();
        }
        return total;
    }

    public double getRevenueForMovie(String movieName) {
        double total = 0;
        for (Transaction t : history) {
            if (t.getMovieName().equals(movieName)) {
                total += t.getPrice();
            }
        }
        return total;
    }

    public int getTransactionCount() {
        return history.size();
    }
}
