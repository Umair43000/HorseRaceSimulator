import java.awt.*;
import javax.swing.*;

class BettingPanel extends JPanel {
    private JTextField betAmountField;

    public BettingPanel() {
        setLayout(new FlowLayout());

        // Input field for the bet amount
        add(new JLabel("Enter Bet Amount:"));
        betAmountField = new JTextField(10);
        add(betAmountField);
    }

    // Get the bet amount entered by the user
    public double getBetAmount() {
        return Double.parseDouble(betAmountField.getText());
    }
}
