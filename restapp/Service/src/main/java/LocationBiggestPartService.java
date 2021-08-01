import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Nikita Nesterov
 */
public class LocationBiggestPartService {



    public LocationBiggestPartService() {
    }


    public LocationBiggestPart getLocationBiggestPart(JSONObject jsonObject) {
        LocationBiggestPart locationBiggestPart = new LocationBiggestPart();

        JSONObject geoArray = (JSONObject) jsonObject.get("geojson");
        JSONArray coordinates = (JSONArray) geoArray.get("coordinates");

        int max = 0;
        int biggestElement = 0;
        JSONArray biggestGeoObject = new JSONArray();
        for(
                int i = 0; i<coordinates.size();i++)

        {
            JSONArray arrayElement = (JSONArray) coordinates.get(i);
            JSONArray arraySubElement = (JSONArray) arrayElement.get(0);
            if (arraySubElement.size() > max) {
                max = arraySubElement.size();
                biggestElement = i;
                biggestGeoObject = arrayElement;
            }
        }
        locationBiggestPart.setJsonArray(biggestGeoObject);
        return locationBiggestPart;

    }
}
