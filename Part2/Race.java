import java.util.concurrent.TimeUnit;

/**
 * A three-horse race, each horse running in its own lane
 * for a given distance
 * 
 * @author McRaceface
 * @version 1.0
 */
public class Race {
    private int raceLength;
    private Horse lane1Horse;
    private Horse lane2Horse;
    private Horse lane3Horse;
    public Horse winner;
    boolean finished = false;

    /**
     * Constructor for objects of class Race
     * Initially, there are no horses in the lanes
     * 
     * @param distance the length of the racetrack (in metres/yards...)
     */
    public Race(int distance) {
        // Initialize instance variables
        raceLength = distance;
        lane1Horse = null;
        lane2Horse = null;
        lane3Horse = null;
    }

    /**
     * Adds a horse to the race in a given lane
     * 
     * @param theHorse the horse to be added to the race
     * @param laneNumber the lane that the horse will be added to
     */
    public void addHorse(Horse theHorse, int laneNumber) {
        if (laneNumber == 1) {
            lane1Horse = theHorse;
        } else if (laneNumber == 2) {
            lane2Horse = theHorse;
        } else if (laneNumber == 3) {
            lane3Horse = theHorse;
        } else {
            System.out.println("Cannot add horse to lane " + laneNumber + " because there is no such lane");
        }
    }

    /**
     * Start the race
     * The horses are brought to the start and then repeatedly moved forward until the 
     * race is finished
     */
    public void startRace() {
        // Declare a local variable to tell us when the race is finished
        finished = false;
        
        // Reset all the lanes (all horses not fallen and back to 0). 
        lane1Horse.goBackToStart();
        lane2Horse.goBackToStart();
        lane3Horse.goBackToStart();
        
        while (!finished) {
            // Move each horse
            moveHorse(lane1Horse);
            moveHorse(lane2Horse);
            moveHorse(lane3Horse);
            
            // Print the race positions
            printRace();
            
            // If any of the three horses has won, the race is finished
            if (raceWonBy(lane1Horse)) {
                finished = true;
                winner = lane1Horse;
            } else if (raceWonBy(lane2Horse)) {
                finished = true;
                winner = lane2Horse;
            } else if (raceWonBy(lane3Horse)) {
                finished = true;
                winner = lane3Horse;
            }
            
            // Wait for 100 milliseconds
            try { 
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nAnd the winner is " + winner.getName() + "!");
    }

    /**
     * Randomly make a horse move forward or fall depending
     * on its confidence rating.
     * A fallen horse cannot move.
     * 
     * @param theHorse the horse to be moved
     */
    private void moveHorse(Horse theHorse) {
        // If the horse has fallen, it cannot move. Only run if it has not fallen.
        if (!theHorse.hasFallen()) {
            // The probability that the horse will move forward depends on the confidence;
            if (Math.random() < theHorse.getConfidence()) {
                theHorse.moveForward();
            }
            
            // The probability that the horse will fall is small (max is 0.1)
            // It will depend exponentially on confidence, so if you double the confidence, the fall probability doubles.
            if (Math.random() < (0.1 * theHorse.getConfidence() * theHorse.getConfidence())) {
                theHorse.fall();
            }
        }
    }

    /** 
     * Determines if a horse has won the race
     *
     * @param theHorse The horse we are testing
     * @return true if the horse has won, false otherwise.
     */
    private boolean raceWonBy(Horse theHorse) {
        return theHorse.getDistanceTravelled() == raceLength;
    }

    /***
     * Print the race on the terminal
     */
    private void printRace() {
        System.out.print('\u000C');  // Clear the terminal window
        
        multiplePrint('=', raceLength + 3); // Top edge of track
        System.out.println();
        
        printLane(lane1Horse);
        System.out.println();
        
        printLane(lane2Horse);
        System.out.println();
        
        printLane(lane3Horse);
        System.out.println();
        
        multiplePrint('=', raceLength + 3); // Bottom edge of track
        System.out.println();
    }

    /**
     * Print a horse's lane during the race.
     * For example: |           X                      | to show how far the horse has run
     */
    private void printLane(Horse theHorse) {
        // Calculate how many spaces are needed before and after the horse
        int spacesBefore = theHorse.getDistanceTravelled();
        int spacesAfter = raceLength - theHorse.getDistanceTravelled();
        
        // Print a | for the beginning of the lane
        System.out.print('|');
        
        // Print the spaces before the horse
        multiplePrint(' ', spacesBefore);
        
        // If the horse has fallen, print 'X'. Otherwise, print the horse's symbol
        if (theHorse.hasFallen()) {
            System.out.print('X');
        } else {
            System.out.print(theHorse.getSymbol());
        }
        
        // Print the spaces after the horse
        multiplePrint(' ', spacesAfter);
        
        // Print the | for the end of the track
        System.out.print('|');
        System.out.print(' ' + theHorse.getName() + " (Current confidence " + theHorse.getConfidence() + ')');
    }

    /***
     * Print a character a given number of times.
     * e.g. printMany('x',5) will print: xxxxx
     * 
     * @param aChar the character to print
     */
    private void multiplePrint(char aChar, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(aChar);
        }
    }

    public static void main(String[] args) {
        // Create a race of length 30
        Race myRace = new Race(30);

        // Create horses
        Horse horse1 = new Horse('A', "PIPPI LONGSTOCKING", 0.6);
        Horse horse2 = new Horse('B', "KOKOMO", 0.6);
        Horse horse3 = new Horse('C', "EL JEFE", 0.4);

        // Add horses to lanes
        myRace.addHorse(horse1, 1);
        myRace.addHorse(horse2, 2);
        myRace.addHorse(horse3, 3);
        
        // Start the race
        myRace.startRace();
    }
}
