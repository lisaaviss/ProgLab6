package Commands;

import Elements.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Класс, который выводит коллекцию
 * @author Артём
 */
public class CommandShow extends Command{
    private static Object objpols(Movie o) {
        Object message;
        message = "id: " + o.getId().toString();
        message = message + "\n" + "name: " + o.getName();
        message = message + "\n" + "coordinates: X: " + o.getCoordinates().getX() + " Y: " + o.getCoordinates().getY();
        message = message + "\n" + "creationDate: " + o.getCreationDate().toString();
        message = message + "\n" + "OscarsCount: " + o.getOscarsCount();
        message = message + "\n" + "totalBoxOffice: " + o.getTotalBoxOffice();
        message = message + "\n" + "genre: " + o.getGenre();
        message = message + "\n" + "mpaarating: " + o.getMpaaRating();
        message = message + "\n" + "Screenwriter's name: " + o.getScreenwriter().getName() + ", Screenwriter's height: " + o.getScreenwriter().getHeight() + ", Screenwriter's eyecolor: " + o.getScreenwriter().getEyeColor() + ", Screenwriter's haircolor: " + o.getScreenwriter().getHairColor() + ", Screenwriter's nationality: " + o.getScreenwriter().getNationality();
        return message;
    }
    public static Object action(ArrayList<Movie> list){
        Object message = "";
        Iterator value = list.iterator();
        if (list.size() != 0) {
            while (value.hasNext()) {
                message = message + "\n" +  objpols((Movie) value.next());
            }
        } else {
            message = "Колекция пуста.";
        }
        return message;
    }
}