package complexy;

import classes.streams.utils.Console;
import classes.streams.utils.Database;
import classes.streams.utils.Videogame;

import java.util.Objects;

public class ValidatorApp {

    public static void main(String[] args) {

        var videogame1 = Database.videogames.get(0);
        var videogame2 = Database.videogames.get(2);
        var videogame3 = Database.videogames.get(3);
        var videogame4 = Database.videogames.get(4);

        //isValidVideogame(videogame4);

        Validator.applyRules(Rules.rules, videogame2);
        System.out.println("Valid videogame");
    }

    private static void isValidVideogame(Videogame videogame) {

        if(Objects.isNull(videogame)) {
            throw new IllegalArgumentException("Cant be null");
        } else {
            if(videogame.getPrice() < 20) {
                throw new InvalidVideogameException("Price must be greater than 20");
            } else if (!videogame.getConsole().equals(Console.XBOX)) {
                throw new InvalidVideogameException("Console must be for XBOX");
            } else if (videogame.getReviews().isEmpty()) {
                throw new InvalidVideogameException("Reviews cannot be empty");
            } else if (videogame.getTotalSold() < 10) {
                throw new InvalidVideogameException("Total sold must be greater than 10");
            } else if(videogame.getIsDiscount()) {
                throw new InvalidVideogameException("Videogame dont have discount");
            }
        }
        System.out.println("Valid videogame");
    }

}
