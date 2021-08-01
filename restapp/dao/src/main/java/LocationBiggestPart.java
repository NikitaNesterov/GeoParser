import org.json.simple.JSONArray;

import java.io.Serializable;

/**
 * @author Nikita Nesterov
 */
public class LocationBiggestPart implements Serializable {

    public static final long serialVersionUID = 1L;
    private JSONArray jsonArray;

    public LocationBiggestPart(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public LocationBiggestPart() {
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    @Override
    public String toString() {
        return "LocationBiggestPart{" +
                "jsonArray=" + jsonArray +
                '}';
    }
}
