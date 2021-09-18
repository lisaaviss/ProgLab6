package Commands;
import Elements.Movie;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

/**
 * Класс управляющий коммандами
 * @author Артём
 */

public class CommandsExecution extends Command {
    public static void objpols(Movie o) {
        System.out.println("id: " + o.getId().toString());
        System.out.println("name: " + o.getName());
        System.out.println("coordinates: X: " + o.getCoordinates().getX() + " Y: " + o.getCoordinates().getY());
        System.out.println("creationDate: " + o.getCreationDate().toString());
        System.out.println("OscarsCount: " + o.getOscarsCount());
        System.out.println("totalBoxOffice: " + o.getTotalBoxOffice());
        System.out.println("genre: " + o.getGenre());
        System.out.println("mpaarating: " + o.getMpaaRating());
        System.out.println("Screenwriter's name: " + o.getScreenwriter().getName() + ", Screenwriter's height: " + o.getScreenwriter().getHeight() + ", Screenwriter's eyecolor: " + o.getScreenwriter().getEyeColor() + ", Screenwriter's haircolor: " + o.getScreenwriter().getHairColor() + ", Screenwriter's nationality: " + o.getScreenwriter().getNationality());

    }
    public static Object action(ArrayList<Movie> list, SortedSet<Integer> all_id, LocalDateTime time_create, String line, String command) throws IOException {
        Object message = "";
        System.out.println(command);
        Movie obj = null;
        if (command.equals("add")){
            CommandHistory.save("add");
            message = CommandAdd.action(list, all_id, line);
        } else if (command.equals("clear")) {
            CommandHistory.save("clear");
            message = CommandClear.action(list);
        } else if (command.equals("count_by_mpaa_rating")) {
            CommandHistory.save("count_by_mpaa_rating");
            message = CommandCountByMparating.action(list, line);
        }else if (command.equals("group_counting_by_genre")){
            CommandHistory.save("group_counting_by_genre");
            message = CommandGroupByGenre.action(list);
        }else if(command.equals("help")) {
            CommandHistory.save("help");
            message = CommandHelp.action();
        }else if(command.equals("history")){
            CommandHistory.save("history");
            message = CommandHistory.action();
        }else if(command.equals("info")){
            CommandHistory.save("info");
            message = CommandInfo.action(list, time_create);
        }else if(command.equals("min_by_name")){
            CommandHistory.save("min_by_name");
            message = CommandMinByName.action(list);
        }else if(command.equals("remove_by_id")) {
            CommandHistory.save("remove_by_id");
            message = CommandRemoveById.action(line, list, all_id);
        }else if(command.equals("update_id")) {
            CommandHistory.save("update_id");
            message = CommandUpdateId.action(list, all_id, line);
        }else if(command.equals("remove_lower")){
            CommandHistory.save("remove_lower");
            message = CommandRemoveLowerElement.action(list, obj, all_id, line);
        }else if(command.equals("shuffle")) {
            CommandHistory.save("shuffle");
            message = CommandShuffle.action(list);
        }else if(command.equals("save")){
            CommandHistory.save("save");
            message = CommandSave.action(list);
        }else if(command.equals("show")){
            CommandHistory.save("show");
            message = CommandShow.action(list);
        }else if(command.equals("execute_script")) {
            CommandHistory.save("execute_script");
            File file = new File("/home/s307470/lab6/show.txt");
            Scanner in = new Scanner(file);
            command = in.nextLine();

        }else {
            message = "Неизвестная команда, для получения списка команд используйте help.";
        }
        System.err.println(message);
        return message;
    }
}

