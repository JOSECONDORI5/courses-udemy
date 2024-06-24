package classes.streams;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ConstructorsStreams {

    public static final Logger log = Logger.getLogger(ConstructorsStreams.class.getName());

    public static void main(String[] args) {
        Stream<Videogame> myStream = Database.videogames.stream();
        myStream.forEach(s -> log.info(s.toString()));
        log.info("----------");

        Integer[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream<Integer> intStream = Arrays.stream(myArray);
        intStream.forEach(t -> log.info(t.toString()));
        log.info("----------");

        Stream.of("Hola", "Mundo").forEach(log::info);
        log.info("----------");

        DoubleStream myDobleStream = DoubleStream.of(20.3, 30.2, 0.0);
        myDobleStream.forEach(t -> log.info(String.valueOf(t)));
    }
}
