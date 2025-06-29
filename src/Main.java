import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "three", "four");

        Stream<String> longStringsStream = strings.stream().filter(s -> {
            System.out.println("Filtering: " + s);
            return s.length() > 3;
        });

        System.out.println("Stream created, filter not applied yet!");

        //longStringsStream.forEach(System.out::println);


    }
}