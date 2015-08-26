package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Text extends Shape {

    private String text;

    public Text(String text, int x, int y, Color color) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g) {
        System.out.println("Drawing text");
        g.setColor(this.color);
        g.drawString(this.text, this.x, this.y);
    }
}
