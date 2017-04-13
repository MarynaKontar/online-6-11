package ua.goit.offline611.sixth_example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL connection example
 * <p>
 * Created by andreymi on 4/12/2017.
 */
public class SocketExample {

    public static void main(String[] args) throws MalformedURLException {
        try {
            // В java для работы с HTTP есть класс HttpURLConnection.
            // Для того бы установить соединение и подключиться необходимо создать элемент типа URL и вызвать у него openConnection
            HttpURLConnection connection = (HttpURLConnection) new URL("http://google.com").openConnection();
            // Необходимо указать что мы хотим данные получать
            connection.setDoInput(true);
            // Подключимся. При это будет отправет метод GET на указанный нами URL.
            // Есть необходимо указать другой метод - можно указать метод в HttpURLConnection
            connection.setRequestMethod("GET");
            connection.connect();
            // Получаем результат и построчно выводим его на экран.
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                bufferedReader.lines().forEach(System.out::println);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
