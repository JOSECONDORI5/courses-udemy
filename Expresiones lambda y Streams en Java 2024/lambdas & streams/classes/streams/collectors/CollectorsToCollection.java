package classes.streams.collectors;

import classes.streams.utils.Database;
import classes.streams.utils.Videogame;

import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Collection;

public class CollectorsToCollection {

    private static final Logger log = Logger.getLogger(CollectorsToCollection.class.getName());

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

//        streamToCollection(videogames, "SET").forEach(v -> log.info(v.toString()));

        streamToMap(videogames).forEach((k, v) -> log.info(k + " : " + v));
    }

    static Collection<Videogame> streamToCollection(Stream<Videogame> stream, String type) {
        return (type.equals("LIST")) ? stream.toList() : stream.collect(Collectors.toSet());
    }

    static Map<String, Double> streamToMap(Stream<Videogame> stream) {
        return stream.distinct().collect(Collectors.toMap(Videogame::getName, Videogame::getPrice));
    }
}