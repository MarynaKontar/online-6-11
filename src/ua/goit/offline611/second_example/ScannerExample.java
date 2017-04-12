package ua.goit.offline611.second_example;

import java.util.Scanner;

/**
 * Examples for scanner usage
 *
 * Created by andreymi on 4/12/2017.
 */
public class ScannerExample {
    public static void main(String[] args) {
        // In java exists specific class for reading from stream : Scanner
        // Scanner take input stream as constructor parameter.
        Scanner scanner = new Scanner(System.in);
        // It can read line until \n or \r\n existed.
        String line = scanner.nextLine();
        System.out.println(line);
        // We can check is next line existed before read?
        System.out.println(scanner.hasNextLine());
        // It can also read numbers using number patters
        System.out.println(scanner.nextDouble());
        // It uses space as separator
        while (scanner.hasNextInt()) {
            System.out.println(scanner.nextInt());
        }

    }
}
