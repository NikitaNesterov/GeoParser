import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @author Nikita Nesterov
 */
public class ConsoleDirector {
    private WordParser wordParser;
    private String fileName;
    private Map<String, String> federalDistrict;
    private Map<String, String> regions;
    private URIBuilderService uriBuilderService;
    private RestWebService restWebService;

    private LocationCentreService locationCentreService;
    private LocationBiggestPartService locationBiggestPartService;
    private CasheService casheService;
    RestParser restParser;

    public ConsoleDirector() throws FileNotFoundException {
        this.wordParser = new WordParser();
        federalDistrict = new HashMap<>();
        regions = new HashMap<>();
        this.uriBuilderService = new URIBuilderService(new StringBuilder());
        this.restWebService = new RestWebService(uriBuilderService);
        this.locationCentreService = new LocationCentreService();
        this.locationBiggestPartService = new LocationBiggestPartService();
        this.casheService = new CasheService();
        this.restParser = new RestParser(restWebService);
    }

    public Map<String, String> getListOfFederalDistricts() throws IOException, ParseException {
        wordParser.setFilename("src/main/resources/Federaldistricts.docx");
        federalDistrict = wordParser.toParse();
        return federalDistrict;
    }

    public void getListOfRegion() throws IOException, ParseException {
        wordParser.setFilename("src/main/resources/ObjectsCode.docx");
        regions = wordParser.toParse();
    }

    public void setObjectTitle(String title) {
        String newTitle = "";
        if (title.length() > 3) {
            String[] longTitle = title.split("\\s");
            newTitle = longTitle[0] + "%20" + longTitle[1];
        } else newTitle = title;
        uriBuilderService.setGeoObjectTitle(newTitle);
    }

    public String getRegionTitle(String code) throws IOException, ParseException {

        String titleToCheck = "";

        Set<Map.Entry<String, String>> allregions = regions.entrySet();
        for (Map.Entry<String, String> all : allregions) {
            if (all.getKey().equals(code)) {
                System.out.println("Код найден");
                System.out.println(all.getValue());
                titleToCheck = all.getValue();
            } else System.out.println("Нет региона с таким номером");

        }
        return titleToCheck;
    }


    public void getObject() throws IOException, ParseException {
        JSONObject jsonObject = restParser.toParse();
        CasheObject casheObject = new CasheObject(
                uriBuilderService.getGeoObjectTitle(),
                locationBiggestPartService.getLocationBiggestPart(jsonObject),
                locationCentreService.getLocationCentre(jsonObject)
        );

        SerialisationObject serialisationObject;
        List<CasheObject> listOfCasheObjects;

        if (casheService.file.exists()) {
            serialisationObject = casheService.deserialize();
            listOfCasheObjects = serialisationObject.getCasheObjectList();
        } else {
            listOfCasheObjects = new ArrayList<>();
            serialisationObject = new SerialisationObject(listOfCasheObjects);

        }
        casheService.getCasheObject(casheObject, listOfCasheObjects);
        System.out.println(casheObject.toString());

        casheService.serialize(serialisationObject);
    }

    public void stopConnection() {
        restWebService.stopConnection();
    }


}
