package optional.practice.practice05;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Practice05Main {
    /**   5. flatMap()으로 중첩 Optional 처리
     *
     *    유저가 존재할수도, 존재하지 않을 수도 있다.
     *    유저가 존재해도, 이메일이 없을 수 있다.
     *    -> Optional<Optional<String>>을 Optional<String>으로 만들고 싶다.
     *
     */

    public static void main(String[] args) {
        List<User> users = initializeUsers();
        Optional<User> user = getUserByName(users, "kim");

        user.ifPresentOrElse(
                u->u.getEmail().ifPresentOrElse(
                        System.out::println,
                        ()-> System.out.println("메일이 없습니다."))
                , () -> System.out.println("User not found"));


    }

    public static List<User> initializeUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("조건희",28, Optional.of("rjs123@naver.com")));
        users.add(new User("이순신",102, Optional.empty()));
        users.add(new User("김유신",70, Optional.empty()));
        users.add(new User("kim",70, Optional.empty()));
        return users;
    }

    public static Optional<User> getUserByName(List<User> users, String name){
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }




}
