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
        boolean moved = false; // position changed
        for(int i = 0; i < 4; i++) {
            if(adj[i] == 'o') {
                move(i, 'X');
                moved = true;
                lastEat = currentTime;
                break;
            }
        }

        // count empty spaces
        int emptySpaces = 0;
        for(int i = 0; i < 4; i++)
            if(adj[i] == ' ')
                emptySpaces++;

        // move to random space if available
        if(emptySpaces > 0) {
            while (!moved) {
                int randomNum = (int)(Math.random() * 4);
                for(int i = 0; i < 4; i++) {
                    if (randomNum == i && adj[i] == ' ') {
                        move(i, 'X');
                        moved = true;
                    }
                }
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
