package Commands;

import Elements.Movie;
import com.sun.xml.internal.ws.api.model.MEP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.stream.Collectors;

/**
 * Класс enum с удалением элемента из коллекции по его id
 * @author Артём
 */
public class CommandRemoveById extends Command {
    public static Object action(String line, ArrayList<Movie> list, SortedSet<Integer> all_id) {
        String[] addArray = line.split(",");
        String id1 = addArray[1];
        int idd1 = Integer.parseInt(id1);
        list.removeAll(list.stream().filter((mb) -> mb.getId() == (idd1)).collect(Collectors.toSet()));
        return "";
    }
}
