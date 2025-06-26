package optional.practice.practice03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Practice03Main {
    /**   3. filter()로 조건부 반환
     *
     *    유저가 존재하더라도, 나이가 100세 이하인 경우에만 출력
     *    100세를 넘는 경우에는 "조건 불일치" 출력
     */

    public static void main(String[] args) {
        List<User> users = initializeUsers();
        Optional<User> john = getUserByName(users, "김유신");
        john.filter(u -> u.getAge() < 100).ifPresentOrElse(System.out::println, () -> System.out.println("조건 불일치"));
    }

    public static List<User> initializeUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("조건희",28));
        users.add(new User("이순신",102));
        users.add(new User("김유신",70));
        return users;
    }

    public static Optional<User> getUserByName(List<User> users, String name){
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }




}
