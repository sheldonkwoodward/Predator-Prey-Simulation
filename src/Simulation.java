/**
 * Created by Sheldon Woodward on 5/19/2017.
 */

public class Simulation {
    // variables
    private Ant[] ants;
    private Doodlebug[] doodlebugs;
    private int time;

    // constructors
    Simulation(int _doodlebugs, int _ants) {
        System.out.println("Stub Simulation constructor called");
    }

    // accessors
    int getTime() {
        return time;
    }

    // methods
    void run() {
        /*
         * move Doodlebugs
         * move Ants
         * breed Doodlebugs
         * breed Ants
         * starve Doodlebugs
         * endSimulation()
         * timeAdvance()
         * wait for input
         */

        System.out.println("Stub run called");
    }
    private void timeAdvance() {
        System.out.println("Stub timeAdvance called");
    }
    private void endSimulation() {
        System.out.println("Stub endSimulation called");
    }
    private void display() {
        System.out.println("Stub display called");
    }
}
