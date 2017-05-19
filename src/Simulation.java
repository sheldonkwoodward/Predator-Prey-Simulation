/**
 * Created by Sheldon Woodward on 5/19/2017.
 */

public class Simulation {
    // variables
    private Doodlebug[] doodlebugs;
    private Ant[] ants;
    private int time;

    // constructors
    Simulation(int _doodlebugs, int _ants) {
        // initialize arrays
        doodlebugs = new Doodlebug[_doodlebugs];
        ants = new Ant[_ants];

        // add doodlebugs and ants
        for(int i = 0; i < _doodlebugs; i++) {
            doodlebugs[i] = new Doodlebug();
        }
        for(int i = 0; i < _ants; i++) {
            ants[i] = new Ant();
        }
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
         * display()
         * wait for input
         */

        display();
    }
    private void timeAdvance() {
        System.out.println("Stub timeAdvance called");
    }
    private void endSimulation() {
        System.out.println("Stub endSimulation called");
    }
    private void display() {
        // retrieve grid
        char[][] grid = Doodlebug.getGrid();

        // print border
        for(int i = 0; i < 22; i++) System.out.print('-');
        System.out.println();

        // print content and border
        for(int y = 0; y < 20; y++) {
            System.out.print('|');
            for(int x = 0; x < 20; x++) {
                System.out.print(grid[y][x]);
            }
            System.out.println('|');
        }

        // print border
        for(int i = 0; i < 22; i++) System.out.print('-');
        System.out.println();
    }
}
