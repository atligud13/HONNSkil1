package is.ru.honn.teiknir.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class Page {
    ArrayList<Shape> drawObjects = new ArrayList<Shape>();

    public Page() {
        drawObjects.add(new Circle(100, 100, 200, Color.RED));
        drawObjects.add(new Rectangle(300, 400, Color.BLUE));
        drawObjects.add(new Line(300, 200, Color.BLACK));
        drawObjects.add(new Text("Atli", 450, 200, Color.GREEN));
    }

    public void addObject(Shape object) {
        drawObjects.add(object);
    }

    public void drawAllObjects(Graphics g) {
        for(Shape s : drawObjects) {
            s.draw(g);
        }
    }
}
