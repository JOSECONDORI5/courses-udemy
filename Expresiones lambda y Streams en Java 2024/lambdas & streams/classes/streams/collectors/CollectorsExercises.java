package classes.streams.collectors;

import classes.streams.utils.Console;
import classes.streams.utils.Database;
import classes.streams.utils.Review;
import classes.streams.utils.Videogame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExercises {

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        // getReviews(videogames).forEach(System.out::print);
        // getWebSites(videogames).forEach((k, v) -> System.out.println(k + " - " + v));
        getConsolesPricesAvg(videogames).forEach((k, v) -> System.out.println(k + " - " + v));
        // getConsolesPricesAvg(videogames).forEach((k, v) -> System.out.println(k + " - " + v));
    }

    /*
     *Regresar una lista inmutable con todos los reviews del stream.
     */
    static List<Review> getReviews(Stream<Videogame> stream) {
        return stream
                .flatMap(videogame -> videogame.getReviews().stream())
                .collect(Collectors.toUnmodifiableList());
    }

    /*
     * Regresar un mapa true con todos los videojuegos que tengan una url(website) con una longitud menor a 15
     *  de lo contrario regresar false con una lista de los videojuegos que no cumplan la condition.
     */
    static Map<Boolean, List<Videogame>> getWebSites(Stream<Videogame> stream) {
        return stream
                .collect(Collectors.partitioningBy(videogame -> videogame.getOfficialWebsite().length() < 15));
    }

    /*
     *  Regresar en un mapa el promedio de ventas todas las consolas
     *  la clave del mapa será la consola y el valor el promedio de ventas.
     */
    static Map<Console, Double> getConsolesPricesAvg(Stream<Videogame> stream) {
        return stream
                .collect(Collectors.groupingBy(
                Videogame::getConsole,
                Collectors.averagingDouble(Videogame::getTotalSold))
        );
    }
}