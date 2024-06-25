package classes.streams.collectors;

import classes.streams.utils.Console;
import classes.streams.utils.Database;
import classes.streams.utils.Videogame;

import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsGroupBySum {

    private static final Logger log = Logger.getLogger(CollectorsGroupBySum.class.getName());

    public static void main(String[] args) {
        Stream<Videogame> videoGames = Database.videogames.stream();

        Map<Console, IntSummaryStatistics> result = videoGames.collect(Collectors.groupingBy(
                Videogame::getConsole,
                Collectors.summarizingInt(Videogame::getTotalSold)
        ));

        result.forEach((k, v) -> log.info(k + "-" + v.getSum()));
    }
}
