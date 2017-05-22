/**
 * Created by Sheldon Woodward on 5/19/2017.
 */

public class Doodlebug extends Organism {
    // variables
    private int lastEat; // timestamp of last eat

    // constructors
    Doodlebug(int currentTime) {
        // call super class constructor
        super(currentTime);

        // setup variables
        lastEat = currentTime;

        // set grid location
        grid[pos[1]][pos[0]] = 'X';
    }
    Doodlebug(int currentTime, int posX, int posY) {
        // call super class constructor
        super(currentTime, posX, posY);

        // setup variables
        lastEat = currentTime;

        // set grid location
        grid[pos[1]][pos[0]] = 'X';
    }

    // accessors
    int getLastEat() {
        return lastEat;
    }

    // methods
    void move(int currentTime) {
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

        // check for ant
        boolean moved = false; // position changed
        if(adj[0] == 'o') {
            move(0, 'X');
            moved = true;
            lastEat = currentTime;
            System.out.println("  Ate ant (" + pos[0] + "," + pos[1] + ")");
        }
        else if(adj[1] == 'o') {
            move(1, 'X');
            moved = true;
            lastEat = currentTime;
            System.out.println("  Ate ant (" + pos[0] + "," + pos[1] + ")");
        }
        else if(adj[2] == 'o') {
            move(2, 'X');
            moved = true;
            lastEat = currentTime;
            System.out.println("  Ate ant (" + pos[0] + "," + pos[1] + ")");
        }
        else if(adj[3] == 'o') {
            move(3, 'X');
            moved = true;
            lastEat = currentTime;
            System.out.println("  Ate ant (" + pos[0] + "," + pos[1] + ")");
        }

        // check for empty space
        int emptySpaces = 0;
        for(int i = 0; i < 4; i++) {
            if(adj[i] == ' ') {
                emptySpaces++;
            }
        }

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
    void starve(int currentTime) {
        if(currentTime - lastEat >= 3 && alive) {
            alive = false;
            grid[pos[1]][pos[0]] = ' ';
            System.out.println("  Doodlebug starved (" + pos[0] + "," + pos[1] + ")");
        }
    }
}
