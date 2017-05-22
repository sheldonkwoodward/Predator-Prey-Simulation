/**
 * Created by Sheldon Woodward on 5/19/2017.
 */

public class Organism {
    // variables
    protected static char[][] grid; // grid of all Organism locations
    protected int[] pos; // index 0 is x, index 1 is y
    protected int lastBreed; // timestamp of last breeding
    protected boolean alive; // alive or dead

    // constructors
    static {
        grid = new char[20][20];
        for(int y = 0; y < 20; y++) {
            for(int x = 0; x < 20; x++) {
                grid[y][x] = ' ';
            }
        }
    }
    Organism(int currentTime) {
        // setup variables
        pos = new int[2];
        lastBreed = currentTime;
        alive = true;

        // random position till empty is found
        do {
            pos[0] = (int)(Math.random() * 20);
            pos[1] = (int)(Math.random() * 20);
        } while(grid[pos[1]][pos[0]] != ' ');
    }
    Organism(int currentTime, int posX, int posY) {
        // setup variables
        pos = new int[2];
        lastBreed = currentTime;
        alive = true;

        // set position
        pos[0] = posX;
        pos[1] = posY;
    }

    // accessors
    static char[][] getGrid() {
        return grid;
    }
    int getPosX() {
        return pos[0];
    }
    int getPosY() {
        return pos[1];
    }
    int getLastBreed() {
        return lastBreed;
    }
    boolean getAlive() {
        return alive;
    }

    // methods
    void move() {
        System.out.println("Stub move called");
    }
    protected void move(int direction, char organismChar) {
        // change old position on grid
        grid[pos[1]][pos[0]] = ' ';

        // do movement
        if(direction == 0) pos[0]++;
        else if(direction == 1) pos[0]--;
        else if(direction == 2) pos[1]++;
        else if(direction == 3) pos[1]--;

        //change new position on grid
        grid[pos[1]][pos[0]] = organismChar;
    }
    int breed(int currentTime, int rate) {
        if(currentTime - lastBreed >= rate && alive) {
            // get adjacent spaces
            char[] adj = new char[4];

            // get adj right
            try {
                adj[0] = grid[pos[1]][pos[0] + 1];
            }
            catch(ArrayIndexOutOfBoundsException e) {
                adj[0] = 'B';
            }

            // get adj left
            try {
                adj[1] = grid[pos[1]][pos[0] - 1];
            }
            catch(ArrayIndexOutOfBoundsException e) {
                adj[1] = 'B';
            }

            // get adj up
            try {
                adj[2] = grid[pos[1] + 1][pos[0]];
            }
            catch(ArrayIndexOutOfBoundsException e) {
                adj[2] = 'B';
            }

            // get adj down
            try {
                adj[3] = grid[pos[1] - 1][pos[0]];
            }
            catch(ArrayIndexOutOfBoundsException e) {
                adj[3] = 'B';
            }

            // breed
            if(adj[0] == ' ') {
                if(rate == 3) System.out.println("  Ant breed (" + pos[0] + "," + pos[1] + ")");
                else System.out.println("  Doodlebug breed (" + pos[0] + "," + pos[1] + ")");
                lastBreed = currentTime;
                return 0;
            }
            else if(adj[1] == ' ') {
                if(rate == 3) System.out.println("  Ant breed (" + pos[0] + "," + pos[1] + ")");
                else System.out.println("  Doodlebug breed (" + pos[0] + "," + pos[1] + ")");
                lastBreed = currentTime;
                return 1;
            }
            else if(adj[2] == ' ') {
                if(rate == 3) System.out.println("  Ant breed (" + pos[0] + "," + pos[1] + ")");
                else System.out.println("  Doodlebug breed (" + pos[0] + "," + pos[1] + ")");
                lastBreed = currentTime;
                return 2;
            }
            else if(adj[3] == ' ') {
                if(rate == 3) System.out.println("  Ant breed (" + pos[0] + "," + pos[1] + ")");
                else System.out.println("  Doodlebug breed (" + pos[0] + "," + pos[1] + ")");
                lastBreed = currentTime;
                return 3;
            }
        }
        return 4;
    }
}
