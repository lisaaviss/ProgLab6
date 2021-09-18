package Elements;
/**
 * Класс с полями, для описания поля Person
 * @author Артём
 */
public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer height; //Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null

    public String getName() {
        return name;
    }
    public Integer getHeight() {
        return height;
    }
    public Color getEyeColor() {
        return eyeColor;
    }
    public Color getHairColor() {
        return hairColor;
    }
    public Country getNationality() {
        return nationality;
    }
    public Person (String name, Integer height, Color eyeColor, Color hairColor, Country nationality){
        this.name = name;
        this.height = height;
        this.eyeColor =eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }
}