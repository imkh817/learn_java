package stream.practice.practice05;

import stream.practice.practice05.Employee;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice05Main {
    /**
     * 부서별 이름 리스트를 수정 불가능한 리스트로 만들기
     */
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "IT"),
                new Employee("Diana", "HR"),
                new Employee("Eve", "Finance")
        );

        Map<String, List<String>> collect = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                Collections::unmodifiableList
                                        )
                                )
                        )
                );

        System.out.println("collect = " + collect);

    }
}
