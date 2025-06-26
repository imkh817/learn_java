package advancedconcepts.concepts01;

import java.util.List;

public class Customer {
    Long id;
    String name;
    String email;
    List<Order> orders;

    public Customer(Long id, String name, String email, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }

    public boolean isVip(Customer customer){
        int sum = customer.getOrders().stream()
                .filter(o -> !o.isCancelled())
                .mapToInt(Order::getTotalAmount)
                .sum();

        return sum >= 500_000;
    }
}
