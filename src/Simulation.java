import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Sheldon Woodward
 * Simulation.java
 */

class Simulation {
    // variables
    final private List<Doodlebug> doodlebugList;
    final private List<Ant> antList;
    private int time;

    // constructors
    @SuppressWarnings("SameParameterValue")
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
            antList.add(new Ant());
        }
    }

    // methods
    @SuppressWarnings("unused")
    void run() {
        run(300, 1, true, false);
    }
    @SuppressWarnings("SameParameterValue")
    void run(int timeDelay, int outputSkipRate, boolean displayGrid, boolean stepThrough) {
        // simulation loop
        while(!endSimulation()) {
            // move doodlebugs
            for(Doodlebug d : doodlebugList) d.move(time);

            // remove dead ants
            for(int i = 0; i < antList.size(); i++)
                if(antList.get(i).checkDead())
                    antList.remove(i);

            // move ants
            for(Ant a : antList) a.move();

            // breed Doodlebugs
            if(time % 8 == 0 && time > 0) {
                int doodlebugNum = doodlebugList.size();
                for (int i = 0; i < doodlebugNum; i++) {
                    // get specific doodlebug info
                    int breed = doodlebugList.get(i).breed();
                    int posX = doodlebugList.get(i).getPosX();
                    int posY = doodlebugList.get(i).getPosY();

                    // spawn new doodlebug in specified breed direction
                    if (breed == 0) doodlebugList.add(new Doodlebug(time, posX + 1, posY));
                    else if (breed == 1) doodlebugList.add(new Doodlebug(time, posX - 1, posY));
                    else if (breed == 2) doodlebugList.add(new Doodlebug(time, posX, posY + 1));
                    else if (breed == 3) doodlebugList.add(new Doodlebug(time, posX, posY - 1));
                }
            }

            // remove dead ants from doodlebug breeding
            for(int i = 0; i < antList.size(); i++)
                if(antList.get(i).checkDead())
                    antList.remove(i);

            // breed Ants
            if(time % 3 == 0 && time > 0) {
                final int antNum = antList.size();
                for (int i = 0; i < antNum; i++) {
                    // get specific ant info
                    int breed = antList.get(i).breed();
                    int posX = antList.get(i).getPosX();
                    int posY = antList.get(i).getPosY();

                    // spawn new ant in specified breed direction
                    if (breed == 0) antList.add(new Ant(posX + 1, posY));
                    else if (breed == 1) antList.add(new Ant(posX - 1, posY));
                    else if (breed == 2) antList.add(new Ant(posX, posY + 1));
                    else if (breed == 3) antList.add(new Ant(posX, posY - 1));
                }
            }

            // starve Doodlebugs
            for(int i = 0; i < doodlebugList.size(); i++)
                if(doodlebugList.get(i).starve(time))
                    doodlebugList.remove(i);

            // output time and display info
            if(time % outputSkipRate == 0) {
                if(displayGrid) System.out.println();

                // show time info
                timeInfo();

                // display grid
                if(displayGrid) display();
            }

            // advance time
            time++;

            // sleep or wait for input
            if(!stepThrough) {
                try {
                    Thread.sleep(timeDelay / outputSkipRate);
                } catch (InterruptedException e) {
                    System.out.println("Sleep exception");
                }
            }
            else {
                Scanner sc = new Scanner(System.in);
                sc.nextLine();
            }
        }
    }
    private boolean endSimulation() {
        return doodlebugList.size() == 0 || antList.size() == 0;
    }
    private void timeInfo() {
        // Time info
        System.out.println("Time: " + time + " Doodlebugs: " + doodlebugList.size()
                + " Ants: " + antList.size());
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
