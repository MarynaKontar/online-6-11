package ua.goit.offline611.four_example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Files examples
 * <p>
 * Created by andreymi on 4/12/2017.
 */
public class FilesExample {
    public static void main(String[] args) {
        // Для работы с файлами в Джава есть класс File
        // Он представляет собой элемент файловой системы и может быть как
        // директорией так и файлом
        // Для того что бы создать елемент типа File существует конструктор с параметром - путь.
        File file = new File("text.txt");
        // Так же можно проверить является файл собственно файлом
        System.out.println(file.isFile());
        // Или директорией
        System.out.println(file.isDirectory());
        // Возможно он скрыт
        System.out.println(file.isHidden());
        // Можно проверить существует ли файл или его езе нет
        System.out.println(file.exists());
        // Выводить полный, абсолютный путь к файлу.
        System.out.println(file.getAbsolutePath());
        // Выводить относительный путь к файлу
        System.out.println(file.getPath());
        // Также можно вывести все елементы которые являются вложенными
        // в текущий элемент файловой системы.
        // Например подпапки в текущей папке.
        System.out.println(Arrays.toString(new File("./").list()));
        // Выводит подэлементы файловой системы, но только не пути а тип File
        System.out.println(Arrays.toString(file.listFiles()));
        // Корневым путум для File является та папка в которой запущена программа.
        System.out.println(new File(".").getAbsolutePath());
        // Особенный путь - для /. В Windows это С:/  в Linux / Unix корень файловой системы.
        System.out.println(new File("/").getAbsolutePath());
        // Допустим у вас есть файл text.txt
        // Будет искать ваш файл в папке запуска программы
        System.out.println(new File("text.txt").getAbsolutePath());
        // Будет искать ваш файл в корневой папке - C:\text.txt
        System.out.println(new File("/text.txt").getAbsolutePath());

        File file2 = new File("text2.mp3");
        System.out.println(file2.exists());
        try {
            // Для того что бы создать новый файл - createNewFile.
            // Метод возвращает true когда можно создать файл. Есть файл уже есть вернется ложь.
            // Так же в отличии от методов выше метод кидает IOException - так как производит манипуляции с файловой системой.
            System.out.println(file2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Для кого что бы читать с файла последством блокирующего IO есть 2 особых класса FileReader и FileInputStream
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            // Читаем наш файл построчно.
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Так же для того что бы читать нащ файл мы можем использоть Scanner
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Для записи в файл последством блокирующего IO существует 2 класса FileWriter и FileOutputStream
        // Второй парамент конструктора FileWriter указывает как будет открыт файл - в режиме дозаписи в конец или с начала
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("Hello3");
            // После записи необходимо сбросить на диск.
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
