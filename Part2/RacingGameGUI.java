import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RacingGameGUI {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private TrackCustomisingPanel trackCustomisingPanel;
    private HorseCustomisingPanel horseCustomisingPanel;
    private BettingPanel bettingPanel;
    private RaceStatsPanel raceStatsPanel;
    private Race race;

    public RacingGameGUI() {
        frame = new JFrame("Horse Racing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        tabbedPane = new JTabbedPane();

        // Create panels for customising
        trackCustomisingPanel = new TrackCustomisingPanel();
        horseCustomisingPanel = new HorseCustomisingPanel();
        bettingPanel = new BettingPanel();
        raceStatsPanel = new RaceStatsPanel();

        // Add panels to tabs
        tabbedPane.addTab("Track Customising", trackCustomisingPanel);
        tabbedPane.addTab("Horse Customising", horseCustomisingPanel);
        tabbedPane.addTab("Betting", bettingPanel);
        tabbedPane.addTab("Race Stats", raceStatsPanel);

        // Add Start Race button in the Race Stats panel
        JPanel racePanel = new JPanel();
        JButton startRaceButton = new JButton("Start Race");
        startRaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startRace();
            }
        });
        racePanel.add(startRaceButton);
        raceStatsPanel.add(racePanel);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    // Method to start the race
    private void startRace() {
        // Get the customised track, horses, and bet amount
        Track track = trackCustomisingPanel.getTrack();
        double betAmount = bettingPanel.getBetAmount();

        // Create the race and show the RaceGUI
        race = new Race(100);
        new RaceGUI(race); // Show the race GUI immediately

        // Start the race
        race.startRace();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RacingGameGUI();
            }
        });
    }
}
