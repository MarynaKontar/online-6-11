package ua.goit.offline611.third_example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

/**
 * Example for usage of readers and writers
 * <p>
 * Created by andreymi on 4/12/2017.
 */
public class ReaderWriterExample {
    public static void main(String[] args) throws IOException {
        // Blocking IO in Java has more abstractions to read and write character streams of data.
        // Readers and Writers.
        Reader reader = null;
        Writer writer = null;
        // Lets take examples for string reader.

        // It was exact same API as in input stream but for characters.
        try {
            reader = new StringReader("test string");
            char[] buffer = new char[100];
            int read;
            while ((read = reader.read(buffer)) > 0) {
                System.out.println(String.copyValueOf(Arrays.copyOfRange(buffer, 0, read)));
            }
            // Most used examples of reader is reader for buffered data.
            // And streams can be nested.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // and in can read by lines.
            System.out.println(bufferedReader.readLine());
            // In java 8 more cool features came.
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            bufferedReader.lines().limit(3).forEach(System.out::println);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        // Write same same classes and possibilities as reflect same functionality.
        try {
            writer = new StringWriter();
            writer.write("Good thing!");
            // Cast to original class and check result of writing.
            StringWriter stringWriter = (StringWriter) writer;
            System.out.println(stringWriter.getBuffer());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        ///
        // Lets write string to console.
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write("Something is happening today!");
        bufferedWriter.close();
    }
}
