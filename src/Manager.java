import Commands.CommandsExecution;
import Elements.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Класс который работает с коллекцией
 */
public class Manager {
    public void fill(ArrayList<Movie> list, SortedSet<Integer> all_id, String file) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean go = false;
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            go = true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            System.exit(0);
        }
        if (go) {
            byte [] data = new byte[1024];
            int amountData = in.read(data, 0, 1024);
            while (amountData == 1024) {
                sb.append(new String(data, StandardCharsets.UTF_8));
                amountData = in.read(data, 0, 1024);
            }
            if (amountData != -1){
                byte[] residue = new byte[amountData];
                System.arraycopy(data, 0, residue, 0, residue.length);
                sb.append(new String(residue, StandardCharsets.UTF_8));
            }
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
                if (sb.length() != 0) {
                    for (Movie obj : g.fromJson(String.valueOf(sb), Movie[].class)) {
                        list.add(obj);
                        if (all_id.contains(obj.getId())) {
                            System.out.println("id объектов коллекции в файле не уникальны");
                            System.exit(0);
                            break;
                        } else {
                            all_id.add(obj.getId());
                        }
                    }
                }
            } catch (com.google.gson.JsonSyntaxException ex){
                System.out.println("Проверьте ваш файл");
                System.exit(0);
            }
        }
    }
}
