package Commands;

import Elements.Movie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;

/**
 * Класс удаляющий из коллекции все элементы, меньшие, чем заданный
 * @author Артём
 */

public class CommandRemoveLowerElement extends Command{
    public static void remove_lower(ArrayList<Movie> lI, Movie o) {
        Iterator value = lI.iterator();
        Movie a;
        boolean ch = false;
        while (value.hasNext()) {
            a = (Movie) value.next();
            if (!ch && a.hashCode()  < o.hashCode()) {
                ch = true;
            }
            if (ch) {
                lI.remove(o);
            }
        }
    }
    public static Object action(ArrayList<Movie> list, Movie obj, SortedSet<Integer> all_id, String line){
        Object message ="";
        if (list.size() > 0) {
            obj = CommandAdd.make_element(all_id.last() + 1, line);
            remove_lower(list, obj);
        }
        return message;
    }
}
