/**
 * Created by Sheldon Woodward on 5/19/2017.
 */

public class Organism {
    // variables
    private static char[][] grid; // grid of all Organism locations
    private int[] pos; // index 0 is x, index 1 is y
    private int lastBreed; // timestamp of last breeding
    private boolean alive; // alive or dead

    // constructors
    static {

    }
    Organism(int posX, int posY) {
        System.out.println("Stub Organism constructor called");
    }

    // accessors
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
    void breed() {
        System.out.println("Stub breed called");
    }
}
