package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Text extends Shape {

    private String text;

    public Text(String text, int x, int y, Color color) {
        this.text = text;
        super.x = x;
        super.y = y;
        super.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.color);
        g.drawString(this.text, super.x, super.y);
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
