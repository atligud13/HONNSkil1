package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Line extends Shape {

    public Line(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g) {
        System.out.println("Drawing line");
        g.setColor(this.color);
        g.drawLine(this.x, this.y, this.x + 100, this.y + 100);
    }
}
