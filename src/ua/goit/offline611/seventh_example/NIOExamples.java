package ua.goit.offline611.seventh_example;

import java.nio.ByteBuffer;
import java.nio.channels.Channel;

/**
 * Примеры с неблокирующим NIO
 *
 * Created by andreymi on 4/12/2017.
 */
public class NIOExamples {
    public static void main(String[] args) {
        // Для работы с неблокрующим IO в java существуют два основных класса ByteBuffer и Channel
        // Первый служит для приема и передачи данных, второй описывает абстракцию канала связи.
        ByteBuffer byteBuffer;
        Channel channel;
        // Основная особенность неблокирующего IO в том что поток не будет заблокирован есть данных есть.
        // Обычно программа сама OS нотифицирует программу о том что то записано в буфер и его можно считать.
        // Channel это интерфейс который можно просто закрыть и проверить не закрыт ли он.
    }
}
