import java.awt.*;
import javax.swing.*;

class RaceStatsPanel extends JPanel {
    private JTextArea statsArea;

    public RaceStatsPanel() {
        setLayout(new BorderLayout());
        statsArea = new JTextArea(10, 40);
        statsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statsArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Method to update race stats
    public void updateStats(String result) {
        statsArea.append(result + "\n");
    }
}
