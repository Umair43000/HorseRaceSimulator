import javax.swing.*;
import java.awt.*;

class TrackCustomisingPanel extends JPanel {
    private JSpinner laneCountSpinner;
    private JSpinner trackLengthSpinner;
    private JComboBox<String> trackShapeComboBox;
    private JComboBox<String> weatherConditionComboBox;

    public TrackCustomisingPanel() {
        setLayout(new GridLayout(4, 2));

        // Number of lanes customisation
        add(new JLabel("Number of Lanes:"));
        laneCountSpinner = new JSpinner(new SpinnerNumberModel(3, 1, 10, 1));
        add(laneCountSpinner);

        // Track length customisation
        add(new JLabel("Track Length (meters):"));
        trackLengthSpinner = new JSpinner(new SpinnerNumberModel(500, 100, 5000, 100));
        add(trackLengthSpinner);

        // Track shape customisation
        add(new JLabel("Track Shape:"));
        trackShapeComboBox = new JComboBox<>(new String[]{"Oval", "Figure-eight", "Custom Shape"});
        add(trackShapeComboBox);

        // Weather condition customisation
        add(new JLabel("Weather Condition:"));
        weatherConditionComboBox = new JComboBox<>(new String[]{"Dry", "Wet", "Icy"});
        add(weatherConditionComboBox);
    }

    // Getters for the customisation values
    public int getLaneCount() {
        return (Integer) laneCountSpinner.getValue();
    }

    public int getTrackLength() {
        return (Integer) trackLengthSpinner.getValue();
    }

    public String getTrackShape() {
        return (String) trackShapeComboBox.getSelectedItem();
    }

    public String getWeatherCondition() {
        return (String) weatherConditionComboBox.getSelectedItem();
    }

    // Get the customised Track object
    public Track getTrack() {
        return new Track(getTrackShape(), getLaneCount(), getTrackLength(), getWeatherCondition());
    }
}
