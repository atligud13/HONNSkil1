package json;

import is.ru.honn.teiknir.shapes.*;
import is.ru.honn.teiknir.shapes.Rectangle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.awt.*;
import java.io.File;
import java.util.Iterator;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class JsonConverter {

    /**
     * Main function for testing
     * @param args
     */
    public static void main(String[] args) {
        FileLoader loader = new FileLoader();
        JsonConverter converter = new JsonConverter();
        try
        {
            String obj = loader.loadFileName("page.json");
            converter.parseJson(obj);
        }
        catch(FileLoadException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * This function takes care of parsing a json file
     * and converting the data into a usable page object
     * that can be drawn.
     * @param json
     * @return
     */
    public Page parseJson(String json) {
        Page page = new Page();
        JSONObject jsonObject = (JSONObject) JSONValue.parse(json);
        JSONArray arr = (JSONArray)jsonObject.get("shapes");
        Iterator<JSONObject> it = arr.iterator();
        while(it.hasNext()) {
            JSONObject shape = it.next();
            String type = (String)shape.get("type");

            /**
             * Fetching variables shared by all shapes
             */
            long longX = (Long)shape.get("x");
            int x = (int) longX;
            long longY = (Long)shape.get("y");
            int y = (int) longY;
            long longColor = (Long)shape.get("color");
            int intColor = (int)longColor;
            Color color = new Color(intColor);

            /**
             * Find out what kind of a shape this is, and then add
             * it to the page
             */
            if(type.equals("Rectangle")) {
                long longW = (Long)shape.get("width");
                long longH = (Long)shape.get("height");
                int width = (int)longW;
                int height = (int)longH;
                Rectangle rect = new Rectangle(x, y, width, height, color);
                page.addObject(rect);
            }
            else if(type.equals("Circle")) {
                long longW = (Long)shape.get("width");
                long longH = (Long)shape.get("height");
                int width = (int)longW;
                int height = (int)longH;
                Circle circ = new Circle(x, y, width, height, color);
                page.addObject(circ);
            }
            else if(type.equals("Line")) {
                long longEndx = (Long)shape.get("endx");
                long longEndy = (Long)shape.get("endy");
                int endx = (int)longEndx;
                int endy = (int)longEndy;
                Line line = new Line(x, y, endx, endy, color);
                page.addObject(line);
            }
            else if(type.equals("Text")) {
                String msg = "Reykjavik university";
                Text text = new Text(msg, x, y, color);
                page.addObject(text);
            }
        }
        return page;
    }
}
