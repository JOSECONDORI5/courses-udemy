package classes.streams;

import java.util.List;

public class VideogameBuilder {
    private String name;
    private Double price;
    private Console console;
    private List<Review> review;
    private String officialWebsite;
    private Boolean isDiscount;
    private Integer totalSold;

    /**
     * @param name the name to set
     */
    public VideogameBuilder name(String name) {
        this.name = name;
        return this;
    }

    /**
     * @param price the price to set
     */
    public VideogameBuilder price(Double price) {
        this.price = price;
        return this;
    }

    /**
     * @param console the console to set
     */
    public VideogameBuilder console(Console console) {
        this.console = console;
        return this;
    }

    /**
     * @param review the review to set
     */
    public VideogameBuilder reviews(List<Review> review) {
        this.review = review;
        return this;
    }

    /**
     * @param officialWebsite the officialWebsite to set
     */
    public VideogameBuilder officialWebsite(String officialWebsite) {
        this.officialWebsite = officialWebsite;
        return this;
    }

    /**
     * @param isDiscount the isDiscount to set
     */
    public VideogameBuilder isDiscount(Boolean isDiscount) {
        this.isDiscount = isDiscount;
        return this;
    }

    /**
     * @param totalSold the totalSold to set
     */
    public VideogameBuilder totalSold(Integer totalSold) {
        this.totalSold = totalSold;
        return this;
    }

    public Videogame build() {
        return new Videogame(name, price, console, review, officialWebsite, isDiscount, totalSold);
    }
}
