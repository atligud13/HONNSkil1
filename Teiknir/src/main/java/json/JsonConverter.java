package json;

import is.ru.honn.teiknir.shapes.Page;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Created by Atli Guðlaugsson on 26/08/2015.
 */
public class JsonConverter {

    enum ShapeNames
    {
        Rectangle, Circle, Line, Text;
    }

    public Page parseJson(String json) {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(json);
        return null;
    }
}
