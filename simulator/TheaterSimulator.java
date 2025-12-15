package simulator;

import model.Customer;
import model.CustomerQueue;
import model.Movie;
import model.MovieManager;
import model.Transactions;

import java.util.Scanner;

public class TheaterSimulator {

    private CustomerQueue queue;
    private MovieManager movieManager;
    private Transactions transactions;

    public TheaterSimulator() {
        queue = new CustomerQueue();
        movieManager = new MovieManager();
        transactions = new Transactions();
    }

    public void setupMovies() {
        movieManager.addMovie("A Allan Adventure", 12.00);
        movieManager.addMovie("A Charlie the Chaplin", 10.00);
        movieManager.addMovie("Burnout Revenge for the PS2: The Movie", 11.00);
    }

    public void addCustomersFromInput() {
        Scanner scanner = new Scanner(System.in);

        for (Movie m : movieManager.getAllMovies().values()) {
            System.out.print("How many people are seeing " + m.getTitle() + "? ");
            int count = scanner.nextInt();

            for (int i = 0; i < count; i++) {
                queue.enqueue(new Customer(m.getTitle()));
            }
        }
    }

    public void runSimulation() {
        while (!queue.isEmpty()) {
            Customer c = queue.dequeue();
            String choice = c.getMovieChoice();

            movieManager.sellTicket(choice);
            double price = movieManager.getAllMovies().get(choice).getPrice();

            transactions.logSale(choice, price);
        }
    }

    public void printResults() {
        movieManager.printMovieReport();

        System.out.println("\n=== Revenue Report ===");
        for (Movie m : movieManager.getAllMovies().values()) {
            System.out.println(
                m.getTitle() + " Revenue: $" +
                transactions.getRevenueForMovie(m.getTitle())
            );
        }

        System.out.println("TOTAL REVENUE: $" + transactions.getTotalRevenue());

        Movie popular = movieManager.getMostPopularMovie();
        if (popular != null) {
            System.out.println("Most Popular Movie: " + popular.getTitle());
        }
    }
}


