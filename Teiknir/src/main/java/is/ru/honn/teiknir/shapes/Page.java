package is.ru.honn.teiknir.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Page {
    ArrayList<Shape> drawObjects = new ArrayList<Shape>();
    Shape selected;

    public Page() {
        drawObjects.add(new Circle(100, 100, 200, Color.RED));
        drawObjects.add(new Rectangle(300, 400, 100, 200, Color.BLUE));
        drawObjects.add(new Line(300, 200, 400, 300, Color.BLACK));
        drawObjects.add(new Text("Atli", 450, 200, Color.GREEN));
        selected = drawObjects.get(0);
    }

    public void addObject(Shape object) {
        drawObjects.add(object);
    }

    public void paint(Graphics g) {
        for(Drawable s : drawObjects) {
            s.draw(g);
        }
    }
}
