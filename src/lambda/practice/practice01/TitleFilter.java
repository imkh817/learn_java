package lambda.practice.practice01;

import java.util.List;

@FunctionalInterface
public interface TitleFilter {
    List<String> filter(String title);
}
