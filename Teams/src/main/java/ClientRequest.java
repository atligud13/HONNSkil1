import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 * Created by Atli Guðlaugsson on 30/08/2015.
 */
public class ClientRequest {
    public String getFileContent(String fileName) throws RequestException {
        FileLoader loader = new FileLoader();
        try
        {
            String content = loader.loadFileName(fileName);
            return content;
        }
        catch(FileLoadException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public String getRequest(String url) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(url).request("application/json").get();

        String json = response.readEntity(String.class);
        response.close();

        return json;
    }
}
