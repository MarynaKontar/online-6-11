package ua.goit.offline611.first_example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * File contains basic examples for IO operations.
 * <p>
 * Created by andreymi on 4/12/2017.
 */
public class BasicExamplesIO {
    // IO stands for input output and covers all communication 'outside' JVM.
    // When talking about IO usually talking about streams.
    // Streams is sequence of bytes coming for some source or passing to some source.
    //
    // Java support two types of IO : blocking and non-blocking.
    // They differ only in way what is happening when data is over and new not yet to come.
    // Blocking - block current thread (obvious) and non-blocking - no.
    //
    // Lets start from blocking.
    //
    // In java for blocking IO existed two main abstractions:
    private static InputStream inputStream;
    private static OutputStream outputStream;
    // They are responsible for writing and reading respectively.

    public static void main(String[] args) throws IOException {
        // In System exists two specific types of blocking stream - console reader and writer.
        inputStream = System.in;
        outputStream = System.out;
        // Lets go on step by step for each method.
        try {
            // Write is used to write array of bytes or single byte or bytes with offset.
            outputStream.write("Hello".getBytes());
        } catch (IOException e) {
            // All java.io methods and java.nio methods throw IOException.
            e.printStackTrace();
        }
        // But they usually left in some buffer, until eventially flush into the stream.
        outputStream.flush();
        // closes the stream.
        //
        //outputStream.close();
        //
        // Read has some overloading methods. One which uses array of bytes - load stream of bytes into array and return
        // number of bytes read.
        byte[] buffer = new byte[100];
        int read;
        while ((read = inputStream.read(buffer)) > 0) {
            System.out.println("Read bytes : " + read);
            outputStream.write(Arrays.copyOfRange(buffer, 0, read));
            outputStream.flush();
        }
        // This is usual read of data from stream.
        // Skip some element from stream
        //inputStream.skip(1);

        // And of course close
        //inputStream.close();

    }

}
