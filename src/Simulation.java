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
         * remove dead ant
         * move Ants
         * breed Doodlebugs
         * breed Ants
         * starve Doodlebugs
         * endSimulation()
         * timeAdvance()
         * display()
         * wait for input
         */

        while(!endSimulation()) {
            // show time info
            System.out.println();
            timeInfo();

            // move doodlebugs
            for(int i = 0; i < 5; i++) {
                if (doodlebugs[i].getAlive()) {
                    doodlebugs[i].move(time);
                }
            }

            // remove dead ants and move living
            for(int i = 0; i < 100; i++) {
                ants[i].checkDead();
            }
            for(int i = 0; i < 100; i++) {
                if(ants[i].getAlive()) {
                    ants[i].move();
                }
            }

            // breed Doodlebugs
            // breed Ants

            // starve Doodlebugs
            for(int i = 0; i < 5; i++) {
                doodlebugs[i].starve(time);
            }

            // display grid
            display();

            // advance time
            timeAdvance();
        }
    }
    private void timeAdvance() {
        // increment time
        time++;
    }
    private boolean endSimulation() {
        int doodlebugsAlive = 0;
        int antsAlive = 0;

        // check doodlebugs
        for(int i = 0; i < 5; i++) {
            if(doodlebugs[i].getAlive()) doodlebugsAlive++;
        }

        // check ants
        for(int i = 0; i < 100; i++) {
            if(ants[i].getAlive()) antsAlive++;
        }

        if(doodlebugsAlive == 0 || antsAlive == 0) return true;
        return false;
    }
    private void timeInfo() {
        //organisms alive
        int dbAlive = 0;
        int antAlive = 0;
        for(int i = 0; i < 5; i++) {
            if(doodlebugs[i].getAlive()) {
                dbAlive++;
            }
        }
        for(int i = 0; i < 100; i++) {
            if(ants[i].getAlive()) {
                antAlive++;
            }
        }

        // Time info
        System.out.println("Time: " + time + " Doodlebugs: " + dbAlive + " Ants: " + antAlive);
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
