package Commands;

import Elements.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class CommandShuffle {
    public static Object action(ArrayList<Movie> list) {
        Collections.shuffle(list);
        return "";
    }
}
