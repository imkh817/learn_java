package stream.practice.practice03;

import stream.practice.practice02.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice03Main {
    /**
     * 이름 중복 제거 후 정렬하여 출력하기
     */
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "IT"),
                new Employee("Diana", "HR"),
                new Employee("Eve", "Finance")
        );

        Map<String, Long> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println("collect = " + collect);
    }
}
