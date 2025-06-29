package benchmark;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Fork(1)
@Warmup(iterations = 2)
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MyFirstBenchmark {

    private List<Integer > numbers;

    @Param({"1000", "1000000", "10000000"})
    private int size;

    @Setup(Level.Iteration)
    public void setUp(){
        numbers = IntStream.range(0, size)
                .boxed()
                .collect(Collectors.toList());
    }
    @Benchmark
    public long countEven_stream(){
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();
    }

    @Benchmark
    public long countEven_parallelStream() {
        return numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();
    }



    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
        /**
         * 결과
         *
         * Benchmark                                    (size)  Mode  Cnt     Score      Error  Units
         * MyFirstBenchmark.countEven_parallelStream      1000  avgt    5    11.561 ±    1.398  us/op
         * MyFirstBenchmark.countEven_parallelStream   1000000  avgt    5   363.578 ±  113.900  us/op
         * MyFirstBenchmark.countEven_parallelStream  10000000  avgt    5  3719.376 ±  997.688  us/op
         * MyFirstBenchmark.countEven_stream              1000  avgt    5     0.512 ±    0.022  us/op
         * MyFirstBenchmark.countEven_stream           1000000  avgt    5   573.901 ±  111.868  us/op
         * MyFirstBenchmark.countEven_stream          10000000  avgt    5  7481.977 ± 1153.888  us/op
         */
    }
}
