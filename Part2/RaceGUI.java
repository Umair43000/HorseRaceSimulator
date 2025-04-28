import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RaceGUI {
    private JFrame raceFrame;
    private JTextArea raceTextArea;
    private Race race;
    private Timer raceTimer;
    private int raceTimeInterval = 100;  // Interval for race updates (milliseconds)

    public RaceGUI(Race race) {
        this.race = race;
        raceFrame = new JFrame("Horse Racing Game - Race In Progress");
        raceFrame.setSize(800, 600);
        raceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JTextArea to display race information
        raceTextArea = new JTextArea();
        raceTextArea.setEditable(false);
        raceTextArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(raceTextArea);
        raceFrame.add(scrollPane, BorderLayout.CENTER);

        raceFrame.setVisible(true);

        // Set up a Timer to update the race every few milliseconds
        raceTimer = new Timer(raceTimeInterval, e -> updateRace());
        raceTimer.start();
    }

    // Update the race progress (displaying the horses' positions)
    private void updateRace() {
        List<Horse> horses = race.getHorses();
        StringBuilder raceStatus = new StringBuilder();

        // Loop through each horse and update its position and status
        for (Horse horse : horses) {
            raceStatus.append(horse.getName()).append(": ");
            int distance = horse.getDistanceTravelled();
            raceStatus.append("Distance: ").append(distance)
                        .append(", Confidence: ").append(horse.getConfidence())
                        .append("\n");
        }

        // Update the JTextArea with the current race status
        raceTextArea.setText(raceStatus.toString());

        // Check if the race has ended
        if (race.finished == true) {
            raceTimer.stop();
            displayRaceWinner();
        }
    }

    // Display the race winner in a dialog box
    private void displayRaceWinner() {
        Horse winner = race.winner;
        JOptionPane.showMessageDialog(raceFrame, "The winner is: " + winner.getName());
    }

    public static void main(String[] args) {
        // Create track and horses
        Track track = new Track("oval",100, 3, ""); 
        Horse horse1 = new Horse('A', "Pip", 0.7);
        Horse horse2 = new Horse('B', "Koko", 0.8);
        Horse horse3 = new Horse('C', "El Jefe", 0.6);
        int length = 100;
        // Create race and start the GUI and race
        Race race = new Race(100);
        new RaceGUI(race); // Show race GUI
        race.startRace();  // Start the race
    }

}
