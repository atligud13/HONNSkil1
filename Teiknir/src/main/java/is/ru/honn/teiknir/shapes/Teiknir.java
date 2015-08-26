package is.ru.honn.teiknir.shapes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Teiknir extends JPanel {
    static Page page = new Page();

    public static void main (String[] argv)
    {
        JFrame f = new JFrame ();

        f.setTitle("Teiknir");
        f.setResizable(true);
        f.setSize(500, 500);

        Teiknir panel = new Teiknir ();
        f.getContentPane().add(panel);
        f.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        page.drawAllObjects(g);
    }

}
