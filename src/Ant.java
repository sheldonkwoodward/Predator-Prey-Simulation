/*
 * Sheldon Woodward
 * Ant.java
 */

class Ant extends Organism {
    // constructors
    Ant() {
        // set grid location
        grid[pos[1]][pos[0]] = 'o';
    }
    Ant(int posX, int posY) {
        // call super class constructor
        super(posX, posY);

        // set grid location
        grid[pos[1]][pos[0]] = 'o';
    }

    // methods
    void move() {
        // get adjacent spaces
        char[] adj = adjacent();

        // check for empty space
        boolean moved = false; // position changed

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
                        move(i, 'o');
                        moved = true;
                    }
                }
            }
        }
    }
    boolean checkDead() {
        return grid[pos[1]][pos[0]] == 'X';
    }
    int breed() {
        // get adjacent spaces
        char[] adj = adjacent();

        // breed
        for(int i = 0; i < 4; i++)
            if(adj[i] == ' ')
                return i;
        return 4;
    }
}
