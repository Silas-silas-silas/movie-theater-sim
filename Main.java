import simulator.TheaterSimulator;

public class Main {
    public static void main(String[] args) {

        TheaterSimulator sim = new TheaterSimulator();

        sim.setupMovies();
        sim.addCustomers(20);
        sim.runSimulation();
        sim.printResults();
    }
}

