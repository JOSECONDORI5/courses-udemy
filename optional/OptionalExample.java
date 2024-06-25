package optional;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> strOptNull = Optional.ofNullable(null);

        Optional<String> strOptNoNull = Optional.of("text");

        String website = strOptNoNull.map(t -> "The text is " + t).orElseThrow(RuntimeException::new);

        System.out.println(strOptNoNull.orElseThrow(() -> new RuntimeException("Text not found")));

        System.out.println(website);

        System.out.println(strOptNull.orElseThrow(() -> new RuntimeException("Text not found")));
    }
}
