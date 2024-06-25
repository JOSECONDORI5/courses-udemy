package classes.streams.collectors;

import classes.streams.utils.Database;
import classes.streams.utils.Videogame;

import java.util.IntSummaryStatistics;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsReduceFunctions {

    private static final Logger log = Logger.getLogger(CollectorsReduceFunctions.class.getName());
    public static void main(String[] args) {
        Stream<Videogame> videoGames = Database.videogames.stream();
        // avg(videoGames);
        // sum(videoGames);
        join(videoGames);
    }

    static void avg(Stream<Videogame> stream) {
        Double avg = stream.collect(Collectors.averagingDouble(Videogame::getPrice));
        log.info(avg::toString);
    }

    static void sum(Stream<Videogame> stream) {
        IntSummaryStatistics summaryStatistics = stream.collect(Collectors.summarizingInt(v -> v.getReviews().size()));
        log.info(() -> String.valueOf(summaryStatistics.getSum()));
        log.info(() -> String.valueOf(summaryStatistics.getMax()));
        log.info(() -> String.valueOf(summaryStatistics.getMin()));
        log.info(() -> String.valueOf(summaryStatistics.getAverage()));
    }

    static void join(Stream<Videogame> stream) {
        String text = stream
                .map(Videogame::toString)
                .collect(Collectors.joining("\n"));
        log.info(text);
    }
}
