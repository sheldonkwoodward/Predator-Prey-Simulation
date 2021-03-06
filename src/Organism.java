/*
 * Sheldon Woodward
 * Organism.java
 */

class Organism {
    // variables
    final static char[][] grid; // grid of all Organism locations
    int[] pos; // index 0 is x, index 1 is y

    // constructors
    static {
        grid = new char[20][20];
        for(int y = 0; y < 20; y++) {
            for(int x = 0; x < 20; x++) {
                grid[y][x] = ' ';
            }
        }
    }
    Organism() {
        // setup variables
        pos = new int[2];

        // random position till empty is found
        do {
            pos[0] = (int)(Math.random() * 20);
            pos[1] = (int)(Math.random() * 20);
        } while(grid[pos[1]][pos[0]] != ' ');
    }
    Organism(int posX, int posY) {
        // set position
        pos = new int[2];
        pos[0] = posX;
        pos[1] = posY;
    }

    // accessors
    @SuppressWarnings("SameReturnValue")
    static char[][] getGrid() {
        return grid;
    }
    int getPosX() {
        return pos[0];
    }
    int getPosY() {
        return pos[1];
    }

    void move(int direction, char organismChar) {
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
    char[] adjacent() {
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

        return adj;
    }
}
