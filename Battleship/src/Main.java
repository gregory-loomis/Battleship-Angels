import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Always launch Swing on the EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Battleship Game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.add(new GridPanel());
                frame.pack();                  // Fit the panel
                frame.setLocationRelativeTo(null); // Center window
                frame.setVisible(true);        // SHOW window
            }
        });
    }
}
