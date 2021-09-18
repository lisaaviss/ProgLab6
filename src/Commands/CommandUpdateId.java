package Commands;

import Elements.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.stream.Collectors;

public class CommandUpdateId {
    public static Object action(ArrayList<Movie> list, SortedSet<Integer> all_id, String line){
        String[] addArray = line.split(",");
        String id1 = addArray[1];
        int idd1 = Integer.parseInt(id1);
        String id2 = addArray[2];
        int idd2 = Integer.parseInt(id2);
        Movie element = list.stream().filter(o -> o.getId().equals(idd1)).collect(Collectors.toList()).get(0);
        list.remove(element);
        element.setId(idd2);
        list.add(element);
        Collections.shuffle(list);
        return "";
    }
}
