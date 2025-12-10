package model;

public class Movie {

    private String title;
    private double price;
    private int ticketsSold;

    public Movie(String title, double price) {
        this.title = title;
        this.price = price;
        this.ticketsSold = 0;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getTicketsSold() {
        return ticketsSold;
    }

    public void sellOne() {
        ticketsSold++;
    }

    public double getRevenue() {
        return ticketsSold * price;
    }

    @Override
    public String toString() {
        return title + " | $" + price + " | Tickets Sold: " + ticketsSold;
    }
}

