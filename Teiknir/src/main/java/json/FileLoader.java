package json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Atli Guðlaugsson on 30/08/2015.
 */
public class FileLoader {
    public String loadFileName(String fileName) throws FileLoadException{
        JSONParser parser = new JSONParser();

        try
        {
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject.toString();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch(ParseException e)
        {
           e.printStackTrace();
        }
        return null;
    }
}
