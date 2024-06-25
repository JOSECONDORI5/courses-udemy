package complexy;

import classes.streams.utils.Console;
import classes.streams.utils.Videogame;

import java.util.List;
import java.util.Objects;

public class Rules {
    private Rules() {}

    private static final Validator<Videogame, RuntimeException> isNull = videogame -> {
        if(Objects.isNull(videogame)) throw new IllegalArgumentException("Cant be null");
    };

    private static final Validator<Videogame, RuntimeException> validPrice = videogame -> {
        if(videogame.getPrice() < 20) throw new InvalidVideogameException("Price must be greater than 20");
    };

    private static final Validator<Videogame, RuntimeException> validConsole = videogame -> {
        if (!videogame.getConsole().equals(Console.XBOX)) throw new InvalidVideogameException("Console must be for XBOX");
    };

    private static final Validator<Videogame, RuntimeException> validReviews = videogame -> {
        if (videogame.getReviews().isEmpty()) throw new InvalidVideogameException("Reviews cannot be empty");
    };

    private static final Validator<Videogame, RuntimeException> validTotalSold = videogame -> {
        if (videogame.getTotalSold() < 10) throw new InvalidVideogameException("Total sold must be greater than 10");
    };

    private static final Validator<Videogame, RuntimeException> validDiscount = videogame -> {
        if(videogame.getIsDiscount())
            throw new InvalidVideogameException("Videogame dont have discount");
    };

    public static List<Validator<Videogame, RuntimeException>> rules = List.of(
            isNull, validPrice, validConsole, validReviews, validDiscount, validTotalSold
    );
}
