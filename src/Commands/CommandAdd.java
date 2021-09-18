package Commands;
/**
 * Класс для добавляения новых элементов коллекци
 * @author Артём
 */
import Elements.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;

public class CommandAdd extends Command {
    public static Movie make_element(int id, String line) {

        ZonedDateTime creationDate = ZonedDateTime.now();
        String[] addArray = line.split(",");
        String name = addArray[1];
        Integer x = Integer.valueOf(addArray[2]);
        int y = Integer.parseInt(addArray[3]);
        int oscarsCount = Integer.parseInt(addArray[4]);
        Long totalBoxOffice = Long.valueOf(addArray[5]);
        MovieGenre genre = MovieGenre.valueOf(addArray[6]);
        MpaaRating mpaaRating = MpaaRating.valueOf(addArray[7]);
        Person screenwriter = null;
        String sname = addArray[8];
        if (sname.length() > 0) {
            Integer height = Integer.valueOf(addArray[9]);
            Color eyeColor = Color.valueOf(addArray[10]);
            Color hairColor = Color.valueOf(addArray[11]);
            Country nationality = Country.valueOf(addArray[12]);
            screenwriter = new Person(sname, height, eyeColor, hairColor, nationality);
        }
        return new Movie(id, name, new Coordinates(x, y), creationDate, oscarsCount, totalBoxOffice, genre, mpaaRating, screenwriter);
    }
    public static Object action(ArrayList<Movie> list, SortedSet<Integer> all_id, String line){
        Object message = "";
        if (list.size() != 0) {
            list.add(make_element(all_id.last() + 1, line));
            all_id.add(all_id.last() + 1);
        } else {
            list.add(make_element(1, line));
            all_id.add(1);
        }
        return message;
    }
}
