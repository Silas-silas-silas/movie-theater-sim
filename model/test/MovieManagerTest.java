package model.test;

import model.Movie;
import model.MovieManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    private MovieManager manager;

    @BeforeEach
    void setUp() {
        manager = new MovieManager();
        manager.addMovie("Movie A", 10.0);
        manager.addMovie("Movie B", 12.0);
    }

    @Test
    void testAddMovie() {
        Movie a = manager.getAllMovies().get("Movie A");

        assertNotNull(a, "Movie A should be added to the HashMap.");
        assertEquals("Movie A", a.getTitle());
        assertEquals(10.0, a.getPrice());
    }

    @Test
    void testSellTicketIncreasesCount() {
        manager.sellTicket("Movie A");

        Movie a = manager.getAllMovies().get("Movie A");

        assertEquals(1, a.getTicketsSold(),
                "Selling 1 ticket should increase ticketsSold to 1.");
    }

    @Test
    void testSellTicketMovieNotFound() {
        // This should NOT crash — just print a message
        manager.sellTicket("Nonexistent Movie");

        // Ensure it did NOT add a new movie
        assertFalse(manager.getAllMovies().containsKey("Nonexistent Movie"),
                "Selling a ticket for a missing movie should NOT create it.");
    }

    @Test
    void testRevenueCalculation() {
        manager.sellTicket("Movie A");
        manager.sellTicket("Movie A");

        double revenue = manager.getRevenue("Movie A");

        assertEquals(20.0, revenue,
                "Revenue should equal ticketsSold * price (2 * 10).");
    }

    @Test
    void testGetMostProfitableMovie() {
        manager.sellTicket("Movie A");
        manager.sellTicket("Movie A"); // 20 revenue
        manager.sellTicket("Movie B"); // 12 revenue

        Movie top = manager.getMostProfitableMovie();

        assertEquals("Movie A", top.getTitle(),
                "Movie A should be the highest revenue movie.");
    }

    @Test
    void testTotalRevenue() {
        manager.sellTicket("Movie A"); // 10
        manager.sellTicket("Movie B"); // 12

        assertEquals(22.0, manager.getTotalRevenue(),
                "Total revenue should be sum of all movie revenues.");
    }
}


