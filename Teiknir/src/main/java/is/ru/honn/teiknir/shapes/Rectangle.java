package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Rectangle extends Shape {

    public Rectangle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g) {
        System.out.println("Drawing rectangle");
        g.setColor(this.color);
        g.drawRect(this.x, this.y, 5, 8);
    }
}
