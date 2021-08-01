/**
 * @author Nikita Nesterov
 */
public class URIBuilderService {

    private String geoObjectTitle = "";
    final String country = "russia";
    final String format = "json";
    final String polygonGeojson = "1";

    StringBuilder stringBuilder;

    public URIBuilderService(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public String getGeoObjectTitle() {
        return geoObjectTitle;
    }

    public String getCountry() {
        return country;
    }

    public String getFormat() {
        return format;
    }

    public String getPolygonGeojson() {
        return polygonGeojson;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void setGeoObjectTitle(String geoObjectTitle) {
        this.geoObjectTitle = geoObjectTitle;
    }


    @Override
    public String toString() {
        return "URIBuilderService{" +
                "geoObjectTitle='" + geoObjectTitle + '\'' +
                ", country='" + country + '\'' +
                ", format='" + format + '\'' +
                ", polygonGeojson='" + polygonGeojson + '\'' +
                '}';
    }

    public StringBuilder getUrl() {
        return stringBuilder.append("http://nominatim.openstreetmap.org/search?" +
                "q=" + geoObjectTitle +
                "&country=" +
                country +
                "&format=" +
                format +
                "&polygon_geojson=" +
                polygonGeojson
        );
    }
}
