package Commands;

import Elements.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * Класс сохранения коллекции в файл
 * @author Артём
 */
public class CommandSave extends  Command{
    public static Object action(ArrayList<Movie> list){
        Object message = "";
        Gson g = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(ZonedDateTime.class, new TypeAdapter<ZonedDateTime>() {
                    @Override
                    public void write(JsonWriter out, ZonedDateTime value) throws IOException {
                        out.value(value.toString());
                    }

                    @Override
                    public ZonedDateTime read(JsonReader in) throws IOException {
                        return ZonedDateTime.parse(in.nextString());
                    }
                })
                .enableComplexMapKeySerialization()
                .create();
        try {
            FileWriter fw = new FileWriter("/Users/macbookprolisaaviss/Desktop/ИТМО/Програмирование/lab6.1/src/Files/oop.json");
            fw.write(g.toJson(list));
            fw.close();
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }
        return message;
    }
}
