package classes.lambdas;

import java.util.List;
import java.util.logging.Logger;

public class PatternStrategy {

    public static final Logger logger = Logger.getLogger(PatternStrategy.class.getName());

    public void applyStrategy() {
        var products = getProducts();

        products.forEach(p -> {
            switch (p.getUserType()) {
                case "PLUS":
                    p.setDiscountStrategy(Strategies.plusDiscount);
                    break;
                case "PRIME":
                    p.setDiscountStrategy(Strategies.primeDiscount);
                    break;
                case "BASIC":
                default:
                    p.setDiscountStrategy(Strategies.basicDiscount);
            }
        });

        products.forEach(p -> logger.info("Price: " + p.getPrice() + " User type: " + p.getUserType() + " Discount: "
                + p.getDiscountStrategy().get(p.getPrice())));
    }

    private static List<Product> getProducts() {
        var product = new Product();
        product.setId(1L);
        product.setName("Bear");
        product.setPrice(150.0);
        product.setUserType("BASIC");

        var product2 = new Product();
        product2.setId(2L);
        product2.setName("Home");
        product2.setPrice(150.0);
        product2.setUserType("PLUS");

        var product3 = new Product();
        product3.setId(3L);
        product3.setName("Dear");
        product3.setPrice(150.0);
        product3.setUserType("PRIME");

        return List.of(product, product2, product3);
    }

    public static void main(String[] args) {
        PatternStrategy patternStrategy = new PatternStrategy();
        patternStrategy.applyStrategy();
    }

    @FunctionalInterface
    public interface ApplyDiscountStrategy {
        Double get(Double price);
    }

    public static class Strategies {

        private Strategies() {
        }

        static ApplyDiscountStrategy basicDiscount = p -> p * 0.02;
        static ApplyDiscountStrategy plusDiscount = p -> p * 0.05;
        static ApplyDiscountStrategy primeDiscount = p -> p * 0.08;
    }

    public static class Product {
        private Long id;
        private String userType;
        private String name;
        private Double price;
        private PatternStrategy.ApplyDiscountStrategy discountStrategy;

        @Override
        public String toString() {
            return "Product [id=" + id + ", userType=" + userType + ", name=" + name + ", price=" + price
                    + ", discountStrategy=" + discountStrategy + "]";
        }

        /**
         * @param id the id to set
         */
        public void setId(Long id) {
            this.id = id;
        }

        /**
         * @return the userType
         */
        public String getUserType() {
            return userType;
        }

        /**
         * @param userType the userType to set
         */
        public void setUserType(String userType) {
            this.userType = userType;
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
         * @return the discountStrategy
         */
        public PatternStrategy.ApplyDiscountStrategy getDiscountStrategy() {
            return discountStrategy;
        }

        /**
         * @param discountStrategy the discountStrategy to set
         */
        public void setDiscountStrategy(PatternStrategy.ApplyDiscountStrategy discountStrategy) {
            this.discountStrategy = discountStrategy;
        }

    }
}
