import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {

    private JButton[][] buttons;

    public GridPanel() {
        buttons = new JButton[10][10];

        // Simple grid layout only
        setLayout(new GridLayout(10, 10));

        // Add buttons to grid
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(40, 40));
                buttons[row][col] = btn;
                add(btn);
            }
        }
    }

    // Getter for later use (controller can add listeners)
    public JButton[][] getButtons() {
        return buttons;
    }
}
