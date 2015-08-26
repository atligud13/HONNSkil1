package is.ru.honn.teiknir.shapes;

import java.awt.*;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public abstract class Shape implements Drawable {
    /**
     * The x and y coordinates and color of the shape
     * All shapes share these variables.
     */
    protected int x, y;
    protected Color color;
    public abstract void draw(Graphics g);
    public abstract void setX(int x);
    public abstract void setY(int y);
}
