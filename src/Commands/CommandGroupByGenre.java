package Commands;

import Elements.Movie;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Класс подсчета количества фильмов по каждой категории жанров
 * @author Артём
 */
public class CommandGroupByGenre extends Command{
    public static Object action(ArrayList<Movie> list){
        Object message = "";
        Iterator value = list.iterator();
        int WESTERN1 = 0;
        int DRAMA1 = 0;
        int THRILLER1 = 0;;
        int HORROR1 = 0;;
        int SCIENCE_FICTION1 = 0;
        while (value.hasNext()){
            switch (((Movie) value.next()).getGenre()){
                case WESTERN:
                    WESTERN1++;
                    break;
                case DRAMA:
                    DRAMA1++;
                    break;
                case THRILLER:
                    THRILLER1++;
                    break;
                case HORROR:
                    HORROR1++;
                    break;
                case SCIENCE_FICTION:
                    SCIENCE_FICTION1++;
                    break;
            }
        }
        message = "Количество WESTERN: " + WESTERN1 + "\nКоличество DRAMA: " + DRAMA1 + "\nКоличество THRILLER: " + THRILLER1 + "\nКоличество HORROR: " + HORROR1 + "\nКоличество SCIENCE_FICTION " + SCIENCE_FICTION1;
        return message;
    }
}
