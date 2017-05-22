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

        // move to random space if available
        int startingNum = (int)(Math.random() * 4);
        for(int i = startingNum; i < startingNum + 4; i++) {
            if(adj[i % 4] == ' ') {
                move(i % 4, 'o');
                return;
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
