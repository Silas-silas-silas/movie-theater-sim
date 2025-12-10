package simulator;

import model.Customer;
import model.CustomerQueue;
import model.Movie;
import model.MovieManager;
import model.TransactionHistory;

public class TheaterSimulator {

    private CustomerQueue queue;
    private MovieManager movieManager;
    private TransactionHistory history;

    public TheaterSimulator() {
        queue = new CustomerQueue();
        movieManager = new MovieManager();
        history = new TransactionHistory();
    }

    /**
     * Sets up movies and their ticket prices.
     */
    public void setupMovies() {
        movieManager.addMovie("Action", 12.00);
        movieManager.addMovie("Romance", 10.00);
        movieManager.addMovie("Horror", 11.00);
    }

    /**
     * Creates a number of customers and randomly assigns them a movie choice.
     */
    public void addCustomers(int count) {
        String[] movies = {"Action", "Romance", "Horror"};

        for (int i = 0; i < count; i++) {
            int choiceIndex = (int)(Math.random() * movies.length);
            queue.enqueue(new Customer(movies[choiceIndex]));
        }
    }

    /**
     * Processes the queue: each customer buys a ticket for their chosen movie.
     */
    public void runSimulation() {
        while (!queue.isEmpty()) {
            Customer c = queue.dequeue();
            String movieChoice = c.getMovieChoice();

            // Sell ticket with HashMap ADT
            movieManager.sellTicket(movieChoice);

            // Record sale in Stack ADT
            double price = movieManager.getAllMovies().get(movieChoice).getPrice();
            history.pushTransaction(movieChoice, price);
        }
    }

    /**
     * Prints full results of the simulation.
     */
    public void printResults() {
        System.out.println("\n===== MOVIE THEATER SIMULATION RESULTS =====");

        movieManager.printMovieReport();

        Movie best = movieManager.getMostProfitableMovie();
        if (best != null) {
            System.out.println("\nTop Movie: " + best.getTitle() +
                    " ($" + best.getRevenue() + ")");
        }

        System.out.println("Total Transactions Logged: " + history.getTransactionCount());
        System.out.println("=============================================\n");
    }
}

