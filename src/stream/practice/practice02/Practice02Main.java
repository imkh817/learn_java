package stream.practice.practice02;

import java.util.List;

public class Practice02Main {
    /**
     * 이름 중복 제거 후 정렬하여 출력하기
     */
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Alice", 25),
                new User("Bob", 35),
                new User("Charlie", 30),
                new User("Bob", 41),
                new User("Alice", 22),
                new User("Eve", 40)
        );

        users.stream()
                .map(User::getName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }
}
