/**
 * Created by Sheldon Woodward on 5/19/2017.
 */

public class Ant extends Organism {
    // constructors
    Ant(int currentTime) {
        // call super class constructor
        super(currentTime);

        // set grid location
        grid[pos[1]][pos[0]] = 'o';
    }
    Ant(int currentTime, int posX, int posY) {
        // call super class constructor
        super(currentTime, posX, posY);

        // set grid location
        grid[pos[1]][pos[0]] = 'o';
    }

    // methods
    void move() {
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

        boolean moved = false; // position changed

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
                        move(i, 'o');
                        moved = true;
                    }
                }
            }
        }
    }
    boolean checkDead() {
        if(grid[pos[1]][pos[0]] == 'X') {
            return true;
        }
        return false;
    }
    int breed(int currentTime) {
        if(currentTime - lastBreed >= 3) {
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
                // System.out.println("  Ant breed (" + pos[0] + "," + pos[1] + ")");
                lastBreed = currentTime;
                return 0;
            }
            else if(adj[1] == ' ') {
                // System.out.println("  Ant breed (" + pos[0] + "," + pos[1] + ")");
                lastBreed = currentTime;
                return 1;
            }
            else if(adj[2] == ' ') {
                // System.out.println("  Ant breed (" + pos[0] + "," + pos[1] + ")");
                lastBreed = currentTime;
                return 2;
            }
            else if(adj[3] == ' ') {
                // System.out.println("  Ant breed (" + pos[0] + "," + pos[1] + ")");
                lastBreed = currentTime;
                return 3;
            }
        }
        return 4;
    }
}
