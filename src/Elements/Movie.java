package Elements;
/**
 * Основной класс, содержащий поля для обработки json и работы пользователя с данными.
 * @author Артём
 */
import java.time.ZonedDateTime;

public class Movie {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int oscarsCount; //Значение поля должно быть больше 0
    private Long totalBoxOffice; //Поле не может быть null, Значение поля должно быть больше 0
    private MovieGenre genre; //Поле может быть null
    private MpaaRating mpaaRating; //Поле не может быть null
    private Person screenwriter;

    public Movie (Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate, int oscarsCount, Long totalBoxOffice, MovieGenre genre, MpaaRating mpaaRating, Person screenwriter){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.totalBoxOffice = totalBoxOffice;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.screenwriter = screenwriter;
    }
   public Integer getId(){
        return id;
   }
   public String getName(){
        return name;
   }
   public Coordinates getCoordinates() {
       return coordinates;
   }
   public ZonedDateTime getCreationDate(){
        return creationDate;
   }
   public int getOscarsCount(){
        return oscarsCount;
   }
   public Long getTotalBoxOffice(){
        return totalBoxOffice;
   }
   public MovieGenre getGenre(){
        return genre;
   }
   public MpaaRating getMpaaRating(){
        return mpaaRating;
   }
   public Person getScreenwriter(){
        return screenwriter;
   }

    public void setId(Integer id) {
        this.id = id;
    }
}