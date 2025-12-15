import simulator.TheaterSimulator;

public class Main {
    public static void main(String[] args) {

        TheaterSimulator sim = new TheaterSimulator();

        sim.setupMovies();
        sim.addCustomersFromInput();
        sim.runSimulation();
        sim.printResults();
    }
}


