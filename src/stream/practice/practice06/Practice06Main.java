package stream.practice.practice06;

import stream.practice.practice06.Employee;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice06Main {
    /**
     * 한번에 여러 통계값 (합계, 평균, 최대, 최소, 개수)를 뽑자.
     */
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR",20),
                new Employee("Bob", "IT",30),
                new Employee("Charlie", "IT",19),
                new Employee("Diana", "HR",50),
                new Employee("Eve", "Finance",30)
        );

        IntSummaryStatistics intSummaryStatistics = employees.stream()
                .collect(Collectors.summarizingInt(Employee::getAge));

        System.out.println("IntSummaryStatistics = " + intSummaryStatistics);


    }
}
