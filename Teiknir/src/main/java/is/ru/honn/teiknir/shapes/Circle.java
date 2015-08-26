package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Circle extends Shape {

    private int radius;

    public Circle(int radius, int x, int y, Color color) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw(Graphics g) {
        System.out.println("Drawing circle");
        g.drawOval(this.x - this.radius, this.y - this.radius, radius, radius);
    }
}
