package model.test;

import model.CustomerQueue;
import model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerQueueTest {
    
    private CustomerQueue queue;

     @BeforeEach
    void setUp() {
        queue = new CustomerQueue();
    }

    @Test
    public void testEnqueueAndSize() {
        queue.enqueue(new Customer( "Movie A"));
        queue.enqueue(new Customer("Movie B"));

        assertEquals(2, queue.size(), "Queue size should be 2 after adding two customers");
    }

    @Test
    public void testPeek() {
        Customer c1 = new Customer("Movie A");
        Customer c2 = new Customer("Movie B");

        queue.enqueue(c1);
        queue.enqueue(c2);

        assertEquals(c1, queue.peek(), "Peek should return the first customer");
        assertEquals(2, queue.size(), "Peek should NOT remove the element");
    }
    @Test
    public void testDequeue() {
        Customer c1 = new Customer("Movie A");
        Customer c2 = new Customer("Movie B");

        queue.enqueue(c1);
        queue.enqueue(c2);

        assertEquals(c1, queue.dequeue(), "First dequque should return the first customer");
        assertEquals(c2, queue.dequeue(), "Second dequque should return the second customer");
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all customers");

    }



    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty(), "Queue should start empty");

        queue.enqueue(new Customer( "Movie A"));
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
    }

}
