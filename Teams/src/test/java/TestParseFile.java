/**
 * Created by Atli Guðlaugsson on 30/08/2015.
 */
public class TestParseFile {
    /**
     * Main function for testing
     * @param args
     */
    public static void main(String[] args) {
        FileLoader loader = new FileLoader();
        TeamParser parser = new TeamParser();
        try
        {
            String obj = loader.loadFileName("teams.json");
            parser.parseAndPrint(obj);
        }
        catch(FileLoadException e)
        {
            e.printStackTrace();
        }

    }
}
