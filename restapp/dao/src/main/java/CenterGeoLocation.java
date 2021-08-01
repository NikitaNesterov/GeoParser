import java.io.Serializable;

/**
 * @author Nikita Nesterov
 */
public class CenterGeoLocation implements Serializable {

    public static final long serialVersionUID = 1L;
    private String latitude;
    private String longitude;

    public CenterGeoLocation() {
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "CenterGeoLocation{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
