import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;


public class GridPanel extends JPanel {

    private JButton[][] buttons;

    public GridPanel() {
        buttons = new JButton[10][10];

        // Simple grid layout only
        setLayout(new BorderLayout(10, 10));

        // Add buttons to grid
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JButton btn = new JButton();
                btn.setPreferredSize(new Dimension(40, 40));
                buttons[row][col] = btn;
                gridPanel.add(btn);
            }
        }

        add(gridPanel, BorderLayout.WEST);
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(250,400));

        add(rightPanel, BorderLayout.CENTER);


    }

    // Getter for later use (controller can add listeners)
    public JButton[][] getButtons() {
        return buttons;
    }

    public JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel gameTitle = new JLabel("Battle Ship", JLabel.CENTER);
        gameTitle.setFont(new Font("Arial", Font.BOLD, 36));
        
        titlePanel.setBorder(new EmptyBorder(20,0,10,0));

        return titlePanel;
    }

    public JButton[][] getButtons(){
        return buttons;
    }
}
//Task
    //Add heading "Battle Ship"
    //Shift grid to the left
    //add panel to the left