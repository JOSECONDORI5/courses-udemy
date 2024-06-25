package classes.streams.operators;

import classes.streams.utils.BasicVideoGame;
import classes.streams.utils.Database;
import classes.streams.utils.Videogame;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class StreamIntermediateOperators {

    public static final Logger log = Logger.getLogger(StreamIntermediateOperators.class.getName());

    public static void main(String[] args) {
        Stream<Videogame> videogame = Database.videogames.stream();
        // distinctOperator(videogame);
        // limitOperator(videogame);
        // skipOperator(videogame);
        // filterOperator(videogame);
        // mapOperator(videogame);
        // flatMapOperator(videogame);
        //mapVSFlatMapOperator(videogame);
        // peekOperator(videogame);
        // sortOperator(videogame);
        // takeWhileOperator(videogame);
        dropWhileOperator(videogame);
    }

    static void distinctOperator(Stream<Videogame> stream) {
        log.info(() -> String.valueOf(stream.distinct().count()));
    }

    static void limitOperator(Stream<Videogame> stream) {
        List<Videogame> videoGames = stream.limit(2).toList();
        videoGames.forEach(v -> log.info(v.toString()));
    }

    static void skipOperator(Stream<Videogame> stream) {
        List<Videogame> videoGames = stream.skip(2).toList();
        videoGames.forEach(v -> log.info(v.toString()));
    }

    static void filterOperator(Stream<Videogame> stream) {
        List<Videogame> videoGames = stream.filter(v -> v.getPrice() > 12.0)
                .filter(v -> !v.getIsDiscount())
                .filter(v -> v.getOfficialWebsite().contains("forza"))
                .toList();
        videoGames.forEach(v -> log.info(v.toString()));
    }

    static void mapOperator(Stream<Videogame> stream) {
        List<BasicVideoGame> basicVideoGames = stream.map(v -> BasicVideoGame.builder()
                .name(v.getName())
                .price(v.getPrice())
                .console(v.getConsole())
                .build()).toList();
        basicVideoGames.forEach(v -> log.info(v.toString()));

        Stream<BasicVideoGame> stream2 = basicVideoGames.stream();
        List<String> titles = stream2.map(BasicVideoGame::getName)
                .toList();
        titles.forEach(log::info);
    }

    static void flatMapOperator(Stream<Videogame> stream) {
        var r = stream.flatMap(v -> v.getReviews().stream()).toList();
        log.info(r::toString);
    }

    static void mapVSFlatMapOperator(Stream<Videogame> stream) {
        long totalReviews = stream.mapToLong(v -> v.getReviews().size()).sum();

        log.info(() -> String.valueOf(totalReviews));
    }

    static void peekOperator(Stream<Videogame> stream) {
        stream.peek(v -> v.setName("")).forEach(v -> log.info(v.toString()));
    }

    static void sortOperator(Stream<Videogame> stream) {
        List<Videogame> listSorted = stream.sorted(Comparator.comparingInt(v -> v.getReviews().size())).toList();
        log.info(listSorted.toString());
    }

    static void takeWhileOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .takeWhile(v -> !v.getName().startsWith("M"))
                .toList();

        r.forEach(s -> log.info(s.toString()));
    }

    static void dropWhileOperator(Stream<Videogame> stream) {
        List<Videogame> r = stream
                .sorted(Comparator.comparing(Videogame::getName))
                .dropWhile(v -> !v.getName().startsWith("M"))
                .toList();

        r.forEach(s -> log.info(s.toString()));
    }
}
