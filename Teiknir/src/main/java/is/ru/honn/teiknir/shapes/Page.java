package is.ru.honn.teiknir.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 * This class takes care of supervising the symbols
 * that are on the canvas.
 */
public class Page {
    ArrayList<Shape> drawObjects = new ArrayList<Shape>();
    Shape selected;

    public void addObject(Shape object) {
        drawObjects.add(object);
        if(this.selected == null) { selected = drawObjects.get(0); }
    }

    public void paint(Graphics g) {
        for(Drawable s : drawObjects) {
            s.draw(g);
        }
    }
}
