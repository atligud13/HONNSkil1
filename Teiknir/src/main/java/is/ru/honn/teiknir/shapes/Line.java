package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Line extends Shape {

    private int x2, y2;

    public Line(int x, int y, int x2, int y2, Color color) {
        super.x = x;
        super.y = y;
        this.x2 = x2;
        this.y2 = y2;
        super.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.color);
        g.drawLine(super.x, super.y, this.x2, this.y2);
    }

    @Override
    public void setX(int x) {
        int moveBuffer = this.x2 - this.x;
        this.x = x;
        this.x2 = this.x + moveBuffer;
    }

    @Override
    public void setY(int y) {
        int moveBuffer = this.y2 - this.y;
        this.y = y;
        this.y2 = this.y + moveBuffer;
    }
}
