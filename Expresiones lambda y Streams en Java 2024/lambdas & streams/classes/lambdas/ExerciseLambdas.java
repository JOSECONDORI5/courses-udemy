package classes.lambdas;

import classes.streams.utils.Console;
import classes.streams.utils.Database;
import classes.streams.utils.Review;
import classes.streams.utils.Videogame;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class ExerciseLambdas {

    private static final Logger log = Logger.getLogger(ExerciseLambdas.class.getName());

    public static void main(String[] args) {
        Stream<Videogame> videogames = Database.videogames.stream();

        exercise5(videogames).forEach(v -> log.info(v.toString()));
    }

    /*
     *Regresar true si el stream contiene al menos un videojuego con número de ventas mayor a 10
     * y no este en descuento o su precio sea mayor a 9.99 de lo contrario regresar false.
     */
    static Boolean exercise1(Stream<Videogame> stream) {
        return stream.anyMatch(videogame ->
                videogame.getTotalSold() > 10 && (!videogame.getIsDiscount() || videogame.getPrice() > 9.99));
    }

    /*
     *Regresar un Stream unicamente con los titulos de todas las consolas que sean de XBOX
     * durante el proceso imprimir los resultados ignorando los repetidos.
     */
    static Stream<String> exercise2(Stream<Videogame> stream) {
        return stream
                .distinct()
                .filter(videogame -> videogame.getConsole().equals(Console.XBOX))
                .peek(videogame -> log.info(videogame.toString()))
                .map(Videogame::getName);
    }

    /*
     *Regresar el videojuego con el mayor número de ventas
     * unicamente contemplando los primers 10 elementos del stream.
     */
    static Videogame exercise3(Stream<Videogame> stream) {
        return stream
                .limit(10)
                .max(Comparator.comparing(Videogame::getTotalSold))
                .orElseThrow(NoSuchElementException::new);
    }

    /*
     *Regresar un stream con todos los comentarios del cada review de todos los videojuegos del stream.
     */
    static Stream<String> exercise4(Stream<Videogame> stream) {
        return stream
                .flatMap(videogame -> videogame.getReviews().stream().map(Review::getComment));
    }

    /*
     *Regresar un stream con los todos los videojuegos con precio menores a 20.0
     * sin utilizar el operador filter().
     */
    static Stream<Double> exercise5(Stream<Videogame> stream) {
        Stream<Double> stream1 = stream
                .sorted(Comparator.comparing(Videogame::getPrice))
                .takeWhile(videogame -> videogame.getPrice() < 20.0)
                .map(Videogame::getPrice);
        return stream1;
    }

}