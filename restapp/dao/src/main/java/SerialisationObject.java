import java.io.Serializable;
import java.util.List;

/**
 * @author Nikita Nesterov
 */
public class SerialisationObject implements Serializable {

    public static final long serialVersionUID = 1L;

    private List<CasheObject> casheObjectList;

    public SerialisationObject(List<CasheObject> casheObjectList) {
        this.casheObjectList = casheObjectList;
    }

    public List<CasheObject> getCasheObjectList() {
        return casheObjectList;
    }

    public void setCasheObjectList(List<CasheObject> casheObjectList) {
        this.casheObjectList = casheObjectList;
    }
}
