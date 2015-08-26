package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Rectangle extends Shape {

    private int width, height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super.x = x;
        super.y = y;
        this.width = width;
        this.height = height;
        super.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.drawRect(super.x, super.y, this.width, this.height);
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
