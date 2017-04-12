package ua.goit.offline611.fifth_example;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Examples for try with resources.
 *
 * Created by andreymi on 4/12/2017.
 */
public class TryWithResExamples {
    public static void main(String[] args) {
        // As you see already closing streams is not ellegaint.
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(new byte[]{1});
            is.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // Exceptions and then covered by exceptions...
        // For this purposes exists special interface AutoClosable.
        AutoCloseable autoCloseable;
        // Each resource with want to be closed after execution - must implement this method.
        // Lets rewrite examples above.
        try (InputStream is2 = new ByteArrayInputStream(new byte[]{1})) {
            is2.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // This strategy called try-with-resources.

    }
}
