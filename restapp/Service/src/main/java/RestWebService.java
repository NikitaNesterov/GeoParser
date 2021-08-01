
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;


/**
 * @author Nikita Nesterov
 */
public class RestWebService {

    URIBuilderService uriBuilderService;
    DefaultHttpClient httpClient;


    public RestWebService(URIBuilderService uriBuilderService) {
        this.uriBuilderService = uriBuilderService;
        httpClient = new DefaultHttpClient();
    }


    public HttpResponse getHttpResponse() {
        HttpResponse response = null;
        try {
            String URI = uriBuilderService.getUrl().toString();


            HttpGet getRequest = new HttpGet(URI);
            getRequest.addHeader("accept", "application/json");


            try {
                response = httpClient.execute(getRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return response;
    }

    public void stopConnection() {
        httpClient.getConnectionManager().shutdown();
    }

}


