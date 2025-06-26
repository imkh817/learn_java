package advancedconcepts.concepts01;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class concept01Main {

    public static void main(String[] args) {
        List<Customer> customers = initializeCustomers();

        List<Customer> validCustomers = findValidCustomers(customers);
        System.out.println("validCustomers = " + validCustomers);

        List<Customer> vipCustomers = findVIPCustomers(validCustomers);
        System.out.println("vipCustomers = " + vipCustomers);


        List<Customer> vipCustomersDomain = findVIPCustomersDomain(validCustomers);
        System.out.println("vipCustomersDomain = " + vipCustomersDomain);

        Map<String, List<String>> stringListMap = filterGenre(validCustomers);
        System.out.println("stringListMap = " + stringListMap);

    }

    public static List<Customer> findValidCustomers(List<Customer> customers){
        return customers.stream()
                .filter(customer -> customer.getEmail() != null && !customer.getOrders().isEmpty())
                .toList();
    }

    public static List<Customer> findVIPCustomers(List<Customer> customers){
        return customers.stream()
                .filter(customer -> {
                    int total = customer.getOrders().stream()
                            .filter(order -> !order.isCancelled())
                            .mapToInt(Order::getTotalAmount)
                            .sum();
                    return total >= 500_000;
                })
                .toList();
    }

    public static List<Customer> findVIPCustomersDomain(List<Customer> customers){
        return customers.stream()
                .filter(customer -> customer.isVip(customer))
                .toList();
    }

    public static  Map<String, List<String>> filterGenre(List<Customer> customers){
        return customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getItems().stream())
                .map(OrderItem::getProductName)
                .collect(Collectors.groupingBy(productName -> productName.split(" ")[0], Collectors.toList()));
    }


    public static List<Customer> initializeCustomers(){
        return List.of(
                new Customer(1L, "Alice", "alice@example.com", List.of(
                        new Order(101L, LocalDate.of(2024, 5, 10), 200_000, false, List.of(
                                new OrderItem("자바의 정석", 1, 30000),
                                new OrderItem("이펙티브 자바", 1, 40000)
                        )),
                        new Order(102L, LocalDate.of(2024, 6, 5), 150_000, false, List.of(
                                new OrderItem("객체지향의 사실과 오해", 1, 25000)
                        ))
                )),
                new Customer(2L, "Bob", null, List.of(
                        new Order(103L, LocalDate.of(2024, 6, 15), 100_000, false, List.of(
                                new OrderItem("스프링 인 액션", 1, 35000)
                        ))
                )),
                new Customer(3L, "Charlie", "charlie@example.com", List.of()),
                new Customer(4L, "Diana", "diana@example.com", List.of(
                        new Order(104L, LocalDate.of(2024, 5, 30), 600_000, false, List.of(
                                new OrderItem("도메인 주도 설계", 1, 50000),
                                new OrderItem("Clean Code", 1, 45000)
                        )),
                        new Order(105L, LocalDate.of(2024, 6, 1), 200_000, true, List.of(
                                new OrderItem("리팩토링", 1, 30000)
                        ))
                ))
        );
    }
}
