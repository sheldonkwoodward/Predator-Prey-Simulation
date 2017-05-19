/**
 * Created by Sheldon Woodward on 5/19/2017.
 */

public class Doodlebug extends Organism {
    // variables
    private int lastEat; // timestamp of last eat

    // constructors
    Doodlebug(int posX, int posY) {
        super(posX,posY);
        System.out.println("Stub Doodlebug constructor called");
    }

    // accessors
    int getLastEat() {
        return lastEat;
    }

    // methods
    void move() {
        System.out.println("Stub move called");
    }
    void breed() {
        System.out.println("Stub breed called");
    }
    void starve() {
        System.out.println("Stub starve called");
    }
}
