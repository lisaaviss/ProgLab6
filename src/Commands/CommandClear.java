    package Commands;
    /**
     * Класс отчистки коллекции
     * @author Артём
     */

    import Elements.Movie;

    import java.util.ArrayList;

    public class CommandClear extends Command {
        public static Object action(ArrayList<Movie> list){
            Object message = "";
            list.clear();
            message = "Коллекция была отчищена";
            return message;
        }
    }
