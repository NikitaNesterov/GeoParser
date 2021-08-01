import java.io.Serializable;

/**
 * @author Nikita Nesterov
 */

public class CasheObject implements Serializable {

    public static final long serialVersionUID = 1L;
    private String objectTitle;
    private CenterGeoLocation centerGeoLocation;
    private LocationBiggestPart locationBiggestPart;

    public CasheObject(String objectTitle, LocationBiggestPart locationBiggestPart, CenterGeoLocation centerGeoLocation) {
        this.objectTitle = objectTitle;
        this.centerGeoLocation = centerGeoLocation;
        this.locationBiggestPart = locationBiggestPart;
    }

    public CasheObject() {
    }

    public String getObjectTitle() {
        return objectTitle;
    }

    public void setObjectTitle(String objectTitle) {
        this.objectTitle = objectTitle;
    }

    public CenterGeoLocation getCenterGeoLocation() {
        return centerGeoLocation;
    }

    public void setCenterGeoLocation(CenterGeoLocation centerGeoLocation) {
        this.centerGeoLocation = centerGeoLocation;
    }

    public LocationBiggestPart getLocationBiggestPart() {
        return locationBiggestPart;
    }

    public void setLocationBiggestPart(LocationBiggestPart locationBiggestPart) {
        this.locationBiggestPart = locationBiggestPart;
    }

    @Override
    public String toString() {
        return "CasheObject{" +
                "objectTitle='" + objectTitle + '\'' +
                ", centerGeoLocation=" + centerGeoLocation +
                ", locationBiggestPart=" + locationBiggestPart +
                '}';
    }
}
