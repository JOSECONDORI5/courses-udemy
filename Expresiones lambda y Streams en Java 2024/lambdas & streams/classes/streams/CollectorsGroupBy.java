package classes.streams;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGroupBy {
    private static Logger log = Logger.getLogger(CollectionsPartitions.class.getName());

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        Map<Console, List<Videogame>> result = videogames.collect(Collectors.groupingBy(Videogame::getConsole));

        result.forEach((k, v) -> log.info(k + "-" + v + "\n"));
    }
}
