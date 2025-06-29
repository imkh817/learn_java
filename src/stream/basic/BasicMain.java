package stream.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicMain {
    public static void main(String[] args) {
        IntStream.range(1, 10)
                .parallel()
                .peek(i -> System.out.println(i + " processed in " + Thread.currentThread().getName()))
                .toArray();
    }
}
