/**
 * Created by Sheldon Woodward on 5/19/2017.
 */

public class Organism {
    // variables
    protected static char[][] grid; // grid of all Organism locations
    protected int[] pos; // index 0 is x, index 1 is y
    protected int lastBreed; // timestamp of last breeding

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
}
