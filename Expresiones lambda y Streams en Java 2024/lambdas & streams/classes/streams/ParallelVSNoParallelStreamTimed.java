package classes.streams;

import java.util.logging.Logger;
import java.util.stream.IntStream;

public class ParallelVSNoParallelStreamTimed {

    private static final Logger log = Logger.getLogger(ParallelVSNoParallelStreamTimed.class.getName());
    public static void main(String[] args) {
        int limit = 200_000_000_0;

        long startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1, limit).reduce(Integer::sum);
        long endTime = System.currentTimeMillis();
        long range = endTime - startTime;
        long finalRange = range;
        log.info(() -> "Total time No parallel: " + finalRange);

        startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1, limit).parallel().reduce(Integer::sum);
        endTime = System.currentTimeMillis();
        range = endTime - startTime;
        long finalRange1 = range;
        log.info(() -> "Total time parallel: " + finalRange1);
    }
}
