package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Circle extends Shape {

    private int radius;

    public Circle(int radius, int x, int y, Color color) {
        this.radius = radius;
        super.x = x;
        super.y = y;
        super.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.color);
        g.drawOval(super.x - this.radius, super.y - this.radius, this.radius, this.radius);
    }

    @Override
    public void setX(int x) {
        super.x = x;
    }

    @Override
    public void setY(int y) {
        super.y = y;
    }
}
