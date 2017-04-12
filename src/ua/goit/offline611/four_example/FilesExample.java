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
        // .. .
        File file = new File("text.txt");
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isHidden());
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        // File: java -jar
        System.out.println(Arrays.toString(new File("./").list()));
        System.out.println(Arrays.toString(file.listFiles()));
        //
        File file2 = new File("text2.mp3");
        System.out.println(file2.exists());
        try {
            System.out.println(file2.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // C:/tmp C:\\tmp
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write("Hello3");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
