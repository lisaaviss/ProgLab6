import Commands.CommandsExecution;
import Elements.Movie;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет
    private static final ArrayList<Movie> collection = new ArrayList<Movie>(); // коллекция
    private static final int port = 4002; // порт для подключения
    private static final Serialization serialization = new Serialization(); // сериализптор/десериализатор
    private static final LocalDateTime today = LocalDateTime.now(); //
    private static final String file = "/Users/macbookprolisaaviss/Desktop/ИТМО/Програмирование/lab6.1/src/Files/oop.json"; // файл с коллекцией
    private static final String serializedDate = "/Users/macbookprolisaaviss/Desktop/ИТМО/Програмирование/lab6.1/src/Files/serializedDate.txt"; // файл для передачи сериализованных сообщений
    private static final SortedSet<Integer> all_id = new TreeSet<>();
    /**
     * Это main)
     *
     * @param args - что-то
     */
    public static void main(String[] args) {
        try {
            Manager manager = new Manager();
            manager.fill(collection, all_id, file);
            System.out.println("Сервер запущен!");
            while (true) {
                connection(true, "non");
                while (true) {
                    String message = read();
                    if (message != null) {
                        write(message, "get");
                        if (message.equals("exit")) {
                            connection(false, "non");
                            break;
                        } else if (message.equals("close server")) {
                            execution("save", today, serializedDate);
                            connection(false,"close server");
                            break;
                        }
                        write(message, "send");
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        }
    }

    /**
     * Модуль выполнения команд
     *
     * @param message - сообщение принятое от клиент
     * @param today - текущая дата
     * @param  - переменная окружения
     * @param serializedDate - файл, где храниться сериализованная команда
     */
    public static void execution(String message, LocalDateTime today, String serializedDate){
        try {
            String command;
            String[] field;
            field = message.split(",");
            command = field[0];
            serialization.SerializeObject(CommandsExecution.action(collection, all_id, today, message, command), serializedDate);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Модуль приёма подключений
     *
     * @param connect - режим работы (отключиться/подключиться)
     * @param close - звкрытие сервера
     * @throws IOException - ошибка подключения
     */
    public static void connection(boolean connect, String close) throws IOException {
        if (connect) {
            server = new ServerSocket(port);
            System.out.println("Ожидание подключения...");
            clientSocket = server.accept();
            System.out.println("Соединение с клиентом установлено");
        }
        if (!connect) {
            System.out.println("Соединение с клиентом разорвано");
            clientSocket.close();
            server.close();
            if (close.equals("close server")){
                System.out.println("Сервер закрыт!");
                System.exit(0);
            }
        }
    }

    /**
     * Модуль чтения запроса
     *
     * @return - возвращает десериализованную команду
     * @throws IOException - ошибка чтения запроса
     */
    public static String read() throws IOException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        String message = in.readLine();
        message = serialization.DeserializeObject(serializedDate);
        return message;
    }

    /**
     * Модуль отправки ответов клиенту
     *
     * @param message - сообщение от клиента
     * @throws IOException - ошибка чтения запроса
     * @throws InterruptedException - ошибка ожидания
     */
    public static void write(String message, String command) throws IOException, InterruptedException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        if (command.equals("get")){
            String messageToClient = "\nСервер принял команду: " + message + "\n";
            serialization.SerializeObject(messageToClient, serializedDate);
            out.write("\n");
            out.flush();
        } else if (command.equals("send")){
            TimeUnit.SECONDS.sleep(1);
            execution(message, today, serializedDate);
            out.write("\n");
            out.flush();
        }
    }
}
