package stream.practice.practice04;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice04Main {
    /**
     * 부서별 직원 이름 목록 구하기
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
                .peek(e -> System.out.println("입력 = " + e))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));

        System.out.println("collect = " + collect);
    }
}
