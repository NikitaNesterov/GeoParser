import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Nikita Nesterov
 */
public class ConsoleView {

    private ConsoleDirector consoleDirector;


    public ConsoleView() throws FileNotFoundException {

        this.consoleDirector = new ConsoleDirector();
    }

    public void start() throws IOException, ParseException {
        String introductionWish = getIntroduction();
        switch (introductionWish) {
            case "1":
                String federalDistrictTitle = getFederalDistricTitle();
                consoleDirector.setObjectTitle(federalDistrictTitle);
                consoleDirector.getObject();
                getFurtherWish();
                break;
            case "2":
                String regionGode = getRegionNumber();
                String regionTitle = consoleDirector.getRegionTitle(regionGode);
                consoleDirector.setObjectTitle(regionTitle);
                consoleDirector.getObject();
                getFurtherWish();
                break;
        }
    }


    private String getIntroduction() {
        System.out.println(
                "\n Прошу Вас выбрать, с федеральным округом или субъектом РФ будем работать: " +
                        "\n1 - Федеральный округ " +
                        "\n2 - Субъект РФ"
        );
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String getFederalDistricTitle() throws IOException, ParseException {
        System.out.println("Просим Вас выбрать один из федеральных округов из списка: ");
        Map<String, String> listofFederalDistricts = consoleDirector.getListOfFederalDistricts();
        for (Map.Entry<String, String> set : listofFederalDistricts.entrySet()) {
            System.out.println(set.getKey() + " " + set.getValue());
        }
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String getRegionNumber() throws IOException, ParseException {
        System.out.println("Просим ввести код субъекта РФ, от 1 до 99 включительно");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private void getFurtherWish() throws IOException, ParseException {
        System.out.println("Желаете продолжить работу с приложением ?" +
                "\n1 - Да " +
                "\n2 - Нет"
        );
        Scanner scanner = new Scanner(System.in);
        String furtherWish = scanner.nextLine();
        switch (furtherWish) {
            case "1":
                start();
                break;
            case "2":
                System.out.println("Спасибо за использование нашего приложения ! Хорошего Вам настроения и удачи в делах!");
                consoleDirector.stopConnection();
                System.exit(0);
        }
    }

    public void stop() {
        consoleDirector.stopConnection();
    }

}
