package classes.streams.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Videogame {
    private String name;
    private Double price;
    private Console console;
    private List<Review> review;
    private String officialWebsite;
    private Boolean isDiscount;
    private Integer totalSold;

    public static VideogameBuilder builder() {
        return new VideogameBuilder();
    }

    /**
     * @param name
     * @param price
     * @param console
     * @param review
     * @param officialWebsite
     * @param isDiscount
     * @param totalSold
     */
    public Videogame(String name, Double price, Console console, List<Review> review, String officialWebsite,
            Boolean isDiscount, Integer totalSold) {
        this.name = name;
        this.price = price;
        this.console = console;
        this.review = review;
        this.officialWebsite = officialWebsite;
        this.isDiscount = isDiscount;
        this.totalSold = totalSold;
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

    /**
     * @return the review
     */
    public List<Review> getReviews() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(List<Review> review) {
        this.review = review;
    }

    /**
     * @return the officialWebsite
     */
    public String getOfficialWebsite() {
        return officialWebsite;
    }

    /**
     * @param officialWebsite the officialWebsite to set
     */
    public void setOfficialWebsite(String officialWebsite) {
        this.officialWebsite = officialWebsite;
    }

    /**
     * @return the isDiscount
     */
    public Boolean getIsDiscount() {
        return isDiscount;
    }

    /**
     * @param isDiscount the isDiscount to set
     */
    public void setIsDiscount(Boolean isDiscount) {
        this.isDiscount = isDiscount;
    }

    /**
     * @return the totalSold
     */
    public Integer getTotalSold() {
        return totalSold;
    }

    /**
     * @param totalSold the totalSold to set
     */
    public void setTotalSold(Integer totalSold) {
        this.totalSold = totalSold;
    }

    @Override
    public String toString() {
        String json = """                    
                {"name":"%s","price":%s,"console":"%s,"reviews":%s,"officialWebsite":"%s","isDiscount":%s,"totalSold":%d}
                """;
        return String.format(json, name, price, console, Arrays.toString(review.toArray()), officialWebsite, isDiscount, totalSold);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Videogame videogame)) return false;
        return Objects.equals(name, videogame.name) && Objects.equals(price, videogame.price) && console == videogame.console && Objects.equals(review, videogame.review) && Objects.equals(officialWebsite, videogame.officialWebsite) && Objects.equals(isDiscount, videogame.isDiscount) && Objects.equals(totalSold, videogame.totalSold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, console, review, officialWebsite, isDiscount, totalSold);
    }
}
