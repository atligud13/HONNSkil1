package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Circle extends Shape {

    private int width;
    private int height;

    public Circle(int width, int height, int x, int y, Color color) {
        this.width = width;
        this.height = height;
        super.x = x;
        super.y = y;
        super.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.color);
        g.drawOval(super.x, super.y, this.width, this.height);
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
