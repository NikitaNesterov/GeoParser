import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Nikita Nesterov
 */
public class RestParser implements ProjectParser {

    RestWebService restWebService;

    public RestParser(RestWebService restWebService) {
        this.restWebService = restWebService;
    }

    @Override
    public JSONObject toParse() throws IOException, ParseException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(restWebService.getHttpResponse().getEntity().getContent()));

        JSONParser jsonParser = new JSONParser();

        JSONArray jsonArray = (JSONArray) jsonParser.parse(in);


        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        return  jsonObject;
    }
}
