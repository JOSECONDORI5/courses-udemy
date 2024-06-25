package optional.utils;

import java.util.Optional;

public class Movie {
    private String name;
    private Double price;

    public Movie(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Optional<String> getName() {
        return Optional.of(name);
    }

    public Optional<Double> getPrice() {
        return Optional.of(price);
    }
}
