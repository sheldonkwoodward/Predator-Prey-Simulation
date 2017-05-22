/*
 * Sheldon Woodward
 * Doodlebug.java
 */

class Doodlebug extends Organism {
    // variables
    private int lastEat; // timestamp of last eat

    // constructors
    Doodlebug(int currentTime) {
        // setup variables
        lastEat = currentTime;

        // set grid location
        grid[pos[1]][pos[0]] = 'X';
    }
    Doodlebug(int currentTime, int posX, int posY) {
        // call super class constructor
        super(posX, posY);

        // setup variables
        lastEat = currentTime;

        // set grid location
        grid[pos[1]][pos[0]] = 'X';
    }

    // methods
    void move(int currentTime) {
        // adjacent spaces
        char[] adj = adjacent();

        // check for ant
        int startingNum = (int)(Math.random() * 4);
        for(int i = startingNum; i < startingNum + 4; i++) {
            if(adj[i % 4] == 'o') {
                move(i % 4, 'X');
                lastEat = currentTime;
                return;
            }
        }

        // move to empty space
        for (int i = startingNum; i < startingNum + 4; i++) {
            if (adj[i % 4] == ' ') {
                move(i % 4, 'X');
                return;
            }
        }
    }
    boolean starve(int currentTime) {
        if(currentTime - lastEat >= 3) {
            grid[pos[1]][pos[0]] = ' ';
            return true;
        }
        return false;
    }
    int breed() {
        // get adjacent spaces
        char[] adj = adjacent();

        // breed
        for(int i = 0; i < 4; i++)
            if(adj[i] == ' ' || adj[i] == 'o')
                return i;
        return 4;
    }
}
