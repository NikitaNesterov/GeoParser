import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlException;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Nikita Nesterov
 */
public class WordParser implements ProjectParser {


    private String filename;

    public WordParser(String filename) throws FileNotFoundException {
        this.filename = filename;
    }

    public WordParser() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public Map toParse() throws IOException, ParseException {

        Map map = new HashMap();

        try (FileInputStream fileInputStream = new FileInputStream(filename)) {

            // открываем файл и считываем его содержимое в объект XWPFDocument
            XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));
            XWPFHeaderFooterPolicy headerFooterPolicy = null;
            try {
                headerFooterPolicy = new XWPFHeaderFooterPolicy(docxFile);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlException e) {
                e.printStackTrace();
            }

            // печатаем содержимое всех параграфов документа в консоль
            List<XWPFParagraph> paragraphs = docxFile.getParagraphs();
            for (XWPFParagraph p : paragraphs) {
                String[] titleArray = p.getText().split("=");
                     map.put(titleArray[0], titleArray[1]);

            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }
}
