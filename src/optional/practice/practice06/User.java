package optional.practice.practice06;

import java.util.Optional;

public class User {
    private String name;
    private int age;
    private Optional<String> email;

    public User(String name){
        this.name = name;
    }

    public User(String name, int age, Optional<String> email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email=" + email +
                '}';
    }
}
