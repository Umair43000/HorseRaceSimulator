import java.awt.*;
import javax.swing.*;

class HorseCustomisingPanel extends JPanel {
    private JComboBox<String> breedSelector;
    private JComboBox<String> coatColorSelector;
    private JComboBox<String> symbolSelector;

    public HorseCustomisingPanel() {
        setLayout(new GridLayout(4, 2));

        // Horse breed selection
        add(new JLabel("Horse Breed:"));
        breedSelector = new JComboBox<>(new String[]{"Thoroughbred", "Arabian", "Quarter Horse"});
        add(breedSelector);

        // Coat color selection
        add(new JLabel("Coat Colour:"));
        coatColorSelector = new JComboBox<>(new String[]{"Brown", "Black", "White", "Grey"});
        add(coatColorSelector);

        // Symbol selection for the horse
        add(new JLabel("Symbol:"));
        symbolSelector = new JComboBox<>(new String[]{"A", "B", "C", "D"});
        add(symbolSelector);
    }

    // Getters for horse customisation values
    public String getBreed() {
        return (String) breedSelector.getSelectedItem();
    }

    public String getCoatColour() {
        return (String) coatColorSelector.getSelectedItem();
    }

    public String getSymbol() {
        return (String) symbolSelector.getSelectedItem();
    }

    // Generate the horses based on user customisations and lane count
    public Horse[] getHorses(int laneCount) {
        Horse[] horses = new Horse[laneCount];
        for (int i = 0; i < horses.length; i++) {
            // Retrieve the symbol, name, and confidence for each horse (using the appropriate methods)
            char horseSymbol = 'A'; // Example method to get horse symbol
            String horseName = "name"; // Example method to get horse name
            double horseConfidence = 0.6; 

            // Create the Horse object with the required constructor
            horses[i] = new Horse(horseSymbol, horseName, horseConfidence);
        }
        return horses;
    }
}
