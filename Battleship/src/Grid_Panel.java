import javax.swing.*;
import java.awt.*;

public class Grid_Panel extends JPanel{
    private JButton[][] buttons;

    public Grid_Panel() {
        buttons = new JButton[10][10];
        setLayout(new BorderLayout());

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(11, 11));

        grid.add(new JLabel(" "));
            



    }
}
