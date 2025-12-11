package model.test;


import model.CustomerQueue;
import model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerQueueTest {
    
    private CustomerQueue queue;

     @BeforeEach
    void setUp() {
        queue = new CustomerQueue();

    }
}
