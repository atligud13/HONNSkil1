package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public abstract class Shape implements Drawable {
    protected int x, y;
    protected Color color;
    public abstract void draw(Graphics g);
}
