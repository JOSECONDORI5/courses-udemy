package classes.streams;

public class BasicVideoGameBuilder {
    private String name;
    private Double price;
    private Console console;

    public BasicVideoGameBuilder() {}

    public BasicVideoGameBuilder(String name, Double price, Console console) {
        this.name = name;
        this.price = price;
        this.console = console;
    }

    public BasicVideoGame build() {
        return new BasicVideoGame(name, price, console);
    }

    public BasicVideoGameBuilder name(String name) {
        this.name = name;
        return this;
    }

    public BasicVideoGameBuilder price(Double price) {
        this.price = price;
        return this;
    }

    public BasicVideoGameBuilder console(Console console) {
        this.console = console;
        return this;
    }

    @Override
    public String toString() {
        return "BasicVideoGameBuilder{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", console=" + console +
                '}';
    }
}
