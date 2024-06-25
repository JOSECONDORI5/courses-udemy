package optional;

import optional.utils.Movie;

import java.util.Optional;

public class FlatMapOptional {
    public static void main(String[] args) {
        Movie movie = new Movie("The run", 20.32);
        Optional<Movie> movieOpt = Optional.of(movie);

        String movieName = movieOpt.flatMap(Movie::getName).get();

        System.out.println(movieName);
    }
}
