import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Nikita Nesterov
 */
public interface ProjectParser {

    Object toParse() throws IOException, ParseException;

}
