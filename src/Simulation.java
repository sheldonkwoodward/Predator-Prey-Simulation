import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sheldon Woodward on 5/19/2017.
 */

public class Simulation {
    // variables
    // private Doodlebug[] doodlebugs;
    // private Ant[] ants;
    private List<Doodlebug> doodlebugList;
    private List<Ant> antList;
    private int time;

    // constructors
    Simulation(int _doodlebugs, int _ants) {
        // initialize arrays
        // doodlebugs = new Doodlebug[_doodlebugs];
        // ants = new Ant[_ants];
        doodlebugList = new ArrayList<>();
        antList = new ArrayList<>();

        // add doodlebugs and ants
        for(int i = 0; i < _doodlebugs; i++) {
            // doodlebugList.get(i) = new Doodlebug();
            doodlebugList.add(new Doodlebug(time));
        }
        for(int i = 0; i < _ants; i++) {
            // antList.get(i) = new Ant();
            antList.add(new Ant(time));
        }
    }

    // accessors
    int getTime() {
        return time;
    }

    // methods
    void run() {
        int timeDelay = 100;
        int outputSkipRate = 1;
        boolean displayGrid = true;

        // simulation loop
        while(!endSimulation()) {
            // move doodlebugs
            for(int i = 0; i < doodlebugList.size(); i++) {
                doodlebugList.get(i).move(time);
            }

            // remove dead ants
            for(int i = 0; i < antList.size(); i++) {
                if(antList.get(i).checkDead()) {
                    antList.remove(i);
                }
            }

            // move ants
            for(int i = 0; i < antList.size(); i++) {
                antList.get(i).move();
            }

            // breed Doodlebugs
            int doodlebugNum = doodlebugList.size();
            for(int i = 0; i < doodlebugNum; i++) {
                // get specific doodlebug info
                int breed = doodlebugList.get(i).breed(time);
                int posX = doodlebugList.get(i).getPosX();
                int posY = doodlebugList.get(i).getPosY();

                // spawn new doodlebug in specified breed direction
                if(breed == 0) doodlebugList.add(new Doodlebug(time, posX + 1, posY));
                else if(breed == 1) doodlebugList.add(new Doodlebug(time, posX - 1, posY));
                else if(breed == 2) doodlebugList.add(new Doodlebug(time, posX, posY + 1));
                else if(breed == 3) doodlebugList.add(new Doodlebug(time, posX, posY - 1));
            }

            // remove dead ants from doodlebug breeding
            for(int i = 0; i < antList.size(); i++) {
                if(antList.get(i).checkDead()) {
                    antList.remove(i);
                }
            }

            // breed Ants
            int antNum = antList.size();
            for(int i = 0; i < antNum; i++) {
                // get specific ant info
                int breed = antList.get(i).breed(time);
                int posX = antList.get(i).getPosX();
                int posY = antList.get(i).getPosY();

                // spawn new ant in specified breed direction
                if(breed == 0) antList.add(new Ant(time, posX + 1, posY));
                else if(breed == 1) antList.add(new Ant(time, posX - 1, posY));
                else if(breed == 2) antList.add(new Ant(time, posX, posY + 1));
                else if(breed == 3) antList.add(new Ant(time, posX, posY - 1));
            }

            // starve Doodlebugs
            for(int i = 0; i < doodlebugList.size(); i++) {
                if(doodlebugList.get(i).starve(time)) {
                    doodlebugList.remove(i);
                }
            }

            if(time % outputSkipRate == 0) {
                if(displayGrid) System.out.println();

                // show time info
                timeInfo();

                // display grid
                if(displayGrid) display();
            }

            // advance time
            timeAdvance();

            // sleep
            try {
                Thread.sleep(timeDelay);
            }
            catch(InterruptedException e) {
                System.out.println("Sleep exception");
            }
        }
    }
    private void timeAdvance() {
        // increment time
        time++;
    }
    private boolean endSimulation() {
        if(doodlebugList.size() == 0 || antList.size() == 0) return true;
        return false;
    }
    private void timeInfo() {
        // Time info
        System.out.println("Time: " + time + " Doodlebugs: " + doodlebugList.size() + " Ants: " + antList.size());
    }
    private void display() {
        // retrieve grid
        char[][] grid = Doodlebug.getGrid();

        // print border
        for(int i = 0; i < 43; i++) System.out.print('-');
        System.out.println();

        // print content and border
        for(int y = 0; y < 20; y++) {
            System.out.print("| ");
            for(int x = 0; x < 20; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.println('|');
        }

        // print border
        for(int i = 0; i < 43; i++) System.out.print('-');
        System.out.println();
    }
}
