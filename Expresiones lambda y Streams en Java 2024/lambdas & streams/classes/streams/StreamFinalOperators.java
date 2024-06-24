package classes.streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class StreamFinalOperators {

    private static final Logger log = Logger.getLogger(StreamFinalOperators.class.getName());

    public static void main(String[] args) {
        Stream<Videogame> videogameStream = Database.videogames.stream();

        // countOperator(videogameStream);
        // forEachOperator(videogameStream);
        // anyMatchOperator(videogameStream);
        // allMatchOperator(videogameStream);
        // noneMatchOperator(videogameStream);
        // findFirstOperator(videogameStream);
        // findAnyOperator(videogameStream);
        // reduceOperator(videogameStream);
        // maxOperator(videogameStream);
        minOperator(videogameStream);
    }

    static void countOperator(Stream<Videogame> stream) {
        log.info(() -> String.valueOf(stream.count()));
    }

    static void forEachOperator(Stream<Videogame> stream) {
        stream.forEach(t -> log.info(t.toString()));
    }

    static void anyMatchOperator(Stream<Videogame> stream) {
        boolean r = stream.anyMatch(videogame -> videogame.getTotalSold() > 1);
        log.info(() -> String.valueOf(r));
    }

    static void allMatchOperator(Stream<Videogame> stream) {
        boolean r = stream.allMatch(videogame -> videogame.getTotalSold() > 150);
        log.info(() -> String.valueOf(r));
    }

    static void noneMatchOperator(Stream<Videogame> stream) {
        boolean r = stream.noneMatch(videogame -> videogame.getReviews().isEmpty());
        log.info(() -> String.valueOf(r));
    }

    static void findFirstOperator(Stream<Videogame> stream) {
        Optional<Videogame> r = stream.findFirst();
        log.info(() -> String.valueOf(r));
    }

    static void findAnyOperator(Stream<Videogame> stream) {
        Optional<Videogame> r = stream.findAny();
        log.info(() -> String.valueOf(r));
    }

    static void reduceOperator(Stream<Videogame> stream) {
        Optional<Integer> r = stream.filter(Videogame::getIsDiscount)
                .map(Videogame::getTotalSold)
                .reduce(Integer::sum);
        log.info(() -> String.valueOf(r));
    }

    static void maxOperator(Stream<Videogame> stream) {
        Optional<Videogame> r = stream.max(Comparator.comparing(Videogame::getName));
        log.info(r.get().getName());
    }

    static void minOperator(Stream<Videogame> stream) {
        Optional<Videogame> r = stream.min(Comparator.comparing(Videogame::getName));
        log.info(r.get().getName());
    }
}
