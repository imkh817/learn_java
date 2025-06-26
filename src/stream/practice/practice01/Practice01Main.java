package stream.practice.practice01;

import java.util.List;
import java.util.stream.Collectors;

public class Practice01Main {
    /**
     * 특정 조건의 유저 목록 필터링 + 이름 추출
     * 요구사항 : 30세 이상의 유저들의 이름을 대문자로 변환하여 리스트로 만들기
     */
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Alice", 25),
                new User("Bob", 35),
                new User("Charlie", 30),
                new User("Diana", 28),
                new User("Eve", 40)
        );

        List<String> filterUser = users.stream()
                .filter(user -> user.getAge() >= 30)
                .map(User::getName)
                .toList();

        System.out.println("filterUser = " + filterUser);

    }
}
