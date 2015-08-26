package is.ru.honn.teiknir.shapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 * A simple drawing application, as of now all the
 * symbols on it are predetermined but they can be moved
 * around using the j m i l and q buttons.
 */
public class Teiknir extends JPanel {
    private Page page = new Page();

    public static void main (String[] argv)
    {
        JFrame f = new JFrame ();

        f.setTitle("Teiknir");
        f.setResizable(true);
        f.setSize(500, 500);

        Teiknir panel = new Teiknir ();
        f.getContentPane().add(panel);
        f.setVisible(true);
        panel.setFocusable(true);
        panel.initListeners();
    }

    /**
     * This function adds a key listener that listens for
     * the keys that take care of moving our objects around the canvas.
     */
    public void initListeners() {
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
                if(page.selected == null) return;
                char key = e.getKeyChar();
                if (key == 'l') {
                    moveRight();
                } else if (key == 'j') {
                    moveLeft();
                } else if (key == 'm') {
                    moveDown();
                } else if (key == 'i') {
                    moveUp();
                } else if (key == 'q') {
                    selectNext();
                }
            }

            public void keyPressed(KeyEvent e) {
                // Do nothing
            }

            public void keyReleased(KeyEvent e) {
                // Do nothing
            }
        });
    }

    /**
     * This function takes care of moving the selected
     * drawable object to the right.
     */
    public void moveRight() {
        page.selected.setX(page.selected.x + 30);
        this.repaint();
    }

    /**
     * This function takes care of moving the selected
     * drawable object to the left
     */
    public void moveLeft() {
        page.selected.setX(page.selected.x - 30);
        this.repaint();
    }

    /**
     * This function takes care of moving the selected
     * drawable object down
     */
    public void moveDown() {
        page.selected.setY(page.selected.y + 30);
        this.repaint();
    }

    /**
     * This function takes care of moving the selected
     * drawable up
     */
    public void moveUp() {
        page.selected.setY(page.selected.y - 30);
        this.repaint();
    }

    /**
     * This function makes the next object in our
     * list of shapes the selected one.
     */
    public void selectNext() {
        int index = page.drawObjects.indexOf(page.selected) + 1;
        if(index >= page.drawObjects.size()) index = 0;
        page.selected = page.drawObjects.get(index);
    }

    /**
     * Override function that takes care of painting our canvas
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.WHITE);
        page.paint(g);
    }

}
