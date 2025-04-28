/**
 * Description of class Horse
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Horse {
    // Fields of class Horse
    private String horseName;
    private char horseSymbol;
    private int distanceTravelled;
    private boolean hasFallen;
    private double horseConfidence;

    // Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence) {
        this.horseSymbol = horseSymbol;
        this.horseName = horseName;
        this.horseConfidence = horseConfidence;
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    // Other methods of class Horse
    public void fall() {
        this.hasFallen = true;
    }

    public double getConfidence() {
        return this.horseConfidence;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public String getName() {
        return this.horseName;
    }

    public char getSymbol() {
        return this.horseSymbol;
    }

    public void goBackToStart() {
        this.distanceTravelled = 0;
        this.hasFallen = false;
    }

    public boolean hasFallen() {
        return this.hasFallen;
    }

    public void moveForward() {
        this.distanceTravelled++;
    }

    public void setConfidence(double newConfidence) {
        if (newConfidence < 0) {
            horseConfidence = 0;
        } else if (newConfidence > 1) {
            horseConfidence = 1;
        } else {
            horseConfidence = newConfidence;
        }
    }

    public void setSymbol(char newSymbol) {
        this.horseSymbol = newSymbol;
    }
}
