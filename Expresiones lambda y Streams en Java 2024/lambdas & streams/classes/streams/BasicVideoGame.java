package classes.streams;

public class BasicVideoGame {
    private String name;
    private Double price;
    private Console console;

    public BasicVideoGame() {
    }

    public static BasicVideoGameBuilder builder() {
        return new BasicVideoGameBuilder();
    }

    /**
     * @param name
     * @param price
     * @param console
     */
    public BasicVideoGame(String name, Double price, Console console) {
        this.name = name;
        this.price = price;
        this.console = console;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return the console
     */
    public Console getConsole() {
        return console;
    }

    /**
     * @param console the console to set
     */
    public void setConsole(Console console) {
        this.console = console;
    }

    @Override
    public String toString() {
        return "BsicVideoGame [name=" + name + ", price=" + price + ", console=" + console + "]";
    }
}
