package model.test;

import model.Transactions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionsTest {

    private Transactions transactions;

    @BeforeEach
    void setUp() {
        transactions = new Transactions();
    }

    @Test
    void testLogSaleAndCount() {
        transactions.logSale("A Allan Adventure", 12.00);
        transactions.logSale("A Charlie the Chaplin", 12.00);
        transactions.logSale("Burnout Revenge for the PS2: The Movie", 12.00);
        transactions.logSale("The Minecraft Movie", 12.00);
        transactions.logSale("Pim Pimpling Has a Pimple", 12.00);

        assertEquals(5, transactions.getTransactionCount(),
                "Should have 5 transactions logged");
    }

    @Test
    void testTotalRevenue() {
        transactions.logSale("A Allan Adventure", 12.00);
        transactions.logSale("A Charlie the Chaplin", 12.00);
        transactions.logSale("Burnout Revenge for the PS2: The Movie", 12.00);
        transactions.logSale("The Minecraft Movie", 12.00);
        transactions.logSale("Pim Pimpling Has a Pimple", 12.00);

        assertEquals(60.0, transactions.getTotalRevenue(), 0.0001,
                "Total revenue should sum all transactions");
    }

    @Test
    void testRevenueForMovie() {
        transactions.logSale("A Allan Adventure", 12.00);
        transactions.logSale("A Charlie the Chaplin", 12.00);
        transactions.logSale("Burnout Revenge for the PS2: The Movie", 12.00);
        transactions.logSale("The Minecraft Movie", 12.00);
        transactions.logSale("Pim Pimpling Has a Pimple", 12.00);

        assertEquals(12.0, transactions.getRevenueForMovie("A Allan Adventure"), 0.0001);
        assertEquals(12.0, transactions.getRevenueForMovie("A Charlie the Chaplin"), 0.0001);
        assertEquals(12.0, transactions.getRevenueForMovie("Burnout Revenge for the PS2: The Movie"), 0.0001);
        assertEquals(12.0, transactions.getRevenueForMovie("The Minecraft Movie"), 0.0001);
        assertEquals(12.0, transactions.getRevenueForMovie("Pim Pimpling Has a Pimple"), 0.0001);
    }
}