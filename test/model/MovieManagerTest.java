package test.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    private MovieManager manager;

    @BeforeEach
    public void setup() {
        manager = new MovieManager();
    }

    @Test
    public void testAddMovie() {
        manager.addMovie("Avatar", 12.99);

        assertNotNull(manager.getMovie("Avatar"));
        assertEquals(12.99, manager.getMovie("Avatar").getPrice());
    }

    @Test
    public void testAddMovie_InvalidPrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addMovie("BadMovie", -10);
        });
    }

    @Test
    public void testSellTicket() {
        manager.addMovie("Matrix", 10);

        manager.sellTicket("Matrix");

        assertEquals(1, manager.getMovie("Matrix").getTicketsSold());
    }

    @Test
    public void testSellTicket_MovieNotFound() {
        // Should not crash — selling a non-existing movie should be handled gracefully
        manager.sellTicket("NotRealMovie");

        // Make sure nothing weird happens
        assertNull(manager.getMovie("NotRealMovie"));
    }

    @Test
    public void testGetMovie() {
        manager.addMovie("Inception", 15.50);

        Movie m = manager.getMovie("Inception");

        assertNotNull(m);
        assertEquals("Inception", m.getTitle());
        assertEquals(15.50, m.getPrice());
    }
}
