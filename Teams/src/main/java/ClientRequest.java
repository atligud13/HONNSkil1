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
}
