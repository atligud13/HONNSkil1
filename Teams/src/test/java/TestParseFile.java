/**
 * Created by Atli Guðlaugsson on 30/08/2015.
 */
public class TestParseFile {
    ClientRequest clientRequest = new ClientRequest();
    TeamParser parser = new TeamParser();

    /**
     * Main function for testing
     * @param args
     */
    public static void main(String[] args) {
        TestParseFile tester = new TestParseFile();

        System.out.println("----Testing with local file------");
        tester.testWithLocalFile();

        System.out.println("");
        System.out.println("----Testing with external file-----");
        tester.testWithExternalFile();

        System.out.println("");
        System.out.println("----Testing League parser------");
        tester.testLeagueParser();
    }

    public void testWithLocalFile() {
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

    public void testWithExternalFile() {
        String content = clientRequest.getRequest("http://olafurandri.com/honn/teams.json");
        parser.parseAndPrint(content);
    }

    public void testLeagueParser() {
        try
        {
            String content = clientRequest.getFileContent("teams.json");
            League league = parser.parseTeams(content);
            league.printLeagueTable();
        }
        catch(RequestException e)
        {
            e.printStackTrace();
        }
    }
}
