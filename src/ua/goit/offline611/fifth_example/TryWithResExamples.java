package ua.goit.offline611.fifth_example;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * Examples for try with resources.
 * <p>
 * Created by andreymi on 4/12/2017.
 */
public class TryWithResExamples {
    public static void main(String[] args) throws SQLException {
        // As you see already closing streams is not ellegaint.
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(new byte[]{1});
            int read = is.read();
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
        //
        /*Connection connection = null;
        Statement statement = connection.createStatement();
        statement.close();
        connection.close();*/

        // Exceptions and then covered by exceptions...
        // For this purposes exists special interface AutoClosable.
        AutoCloseable autoCloseable;
        // Each resource with want to be closed after execution - must implement this method.
        // Lets rewrite examples above.
        try (InputStream is2 = new ByteArrayInputStream(new byte[]{1})) {
            is2.read();
        } catch (IOException e) {
            e.printStackTrace();
            //e.getSuppressed();
        }
        // This strategy called try-with-resources.
        try (EvilClosable evilClosable = new EvilClosable()) {
            System.out.println("Done");
            evilClosable.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Arrays.toString(e.getSuppressed()));
        }

//        int i;
//        {
//            int j; {
//               int k;
//            }
//        }

        try (EvilClosable evilClosable1 = new EvilClosable();
             EvilClosable evilClosable2 = new EvilClosable();) {
            System.out.println("Done");
            evilClosable1.run();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(Arrays.toString(e.getSuppressed()));
        }



    }

    private static class EvilClosable implements Closeable {

        void run() {
            throw new RuntimeException("Hi-hi-hi!");
        }

        @Override
        public void close() throws IOException {
           throw new RuntimeException("Ha-ha-ha!");
        }
    }

}
