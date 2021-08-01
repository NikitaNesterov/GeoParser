import org.json.simple.parser.ParseException;
import java.io.IOException;


/**
 * @author Nikita Nesterov
 */
public class MainClient {

    public static void main(String[] args) throws IOException, ParseException {
        ConsoleView consoleView = new ConsoleView();
        System.out.println("Вас приветствует приложение по поиску координат центральных и крупнейших объектов субъектов РФ и федеральных округов России !");
        consoleView.start();
        consoleView.stop();
    }
}
