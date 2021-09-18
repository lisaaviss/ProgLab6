package Elements;
/**
 * Класс с координатами
 * @author Артём
 */
public class Coordinates {
    private Integer x; //Поле не может быть null
    private int y; //Максимальное значение поля: 92

    public Integer getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public  Coordinates (Integer x, int y) {
        this.x = x;
        this.y = y;
    }
}