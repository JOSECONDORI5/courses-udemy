package classes.streams;

import classes.streams.utils.Database;
import classes.streams.utils.Review;
import classes.streams.utils.Videogame;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class DebuggerStream {

    private static final Logger log = Logger.getLogger(DebuggerStream.class.getName());

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        var myArray = videogames
                .distinct()
                .sorted(Comparator.comparing(Videogame::getTotalSold))
                .flatMap(videogame -> videogame.getReviews().stream().map(Review::getComment))
                .filter(comment -> comment.contains("best"))
                .map("Good comment: "::concat)
                .toArray();

        log.info(() -> Arrays.toString(myArray));
    }
}
