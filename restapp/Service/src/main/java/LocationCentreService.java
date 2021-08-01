import org.json.simple.JSONObject;

/**
 * @author Nikita Nesterov
 */
public class LocationCentreService {


    public LocationCentreService() {
    }

    public CenterGeoLocation getLocationCentre(JSONObject jsonObject) {
        CenterGeoLocation centerGeoLocation = new CenterGeoLocation();
        String lat = (String) jsonObject.get("lat");
        String lon = (String) jsonObject.get("lon");
        centerGeoLocation.setLatitude(lat);
        centerGeoLocation.setLongitude(lon);
        return centerGeoLocation;
    }

}
