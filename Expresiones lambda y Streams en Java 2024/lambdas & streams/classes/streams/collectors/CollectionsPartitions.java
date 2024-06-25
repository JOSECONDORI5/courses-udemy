package classes.streams.collectors;

import classes.streams.utils.Database;
import classes.streams.utils.Videogame;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsPartitions {

    private static Logger log = Logger.getLogger(CollectionsPartitions.class.getName());

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        Map<Boolean, List<Videogame>> result = videogames.collect(Collectors.partitioningBy(v -> v.getPrice() > 15));

        result.forEach((k, v) -> log.info(k + "-" + v));
    }
}
