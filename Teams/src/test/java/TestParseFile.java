/**
 * Created by Atli Guðlaugsson on 30/08/2015.
 */
public class TestParseFile {
    /**
     * Main function for testing
     * @param args
     */
    public static void main(String[] args) {
        ClientRequest clientRequest = new ClientRequest();
        TeamParser parser = new TeamParser();

        try
        {
            String content = clientRequest.getFileContent("teams.json");
            parser.parseAndPrint(content);
        }
        catch(RequestException e)
        {
            e.printStackTrace();
        }

    }
}
