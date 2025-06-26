package optional.practice.practice04;

import optional.practice.practice04.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Practice04Main {
    /**   4. ifPresent()로 후처리
     *
     *    유저가 존재한다면, 이름을 대문자로 바꿔 출력
     *    없으면 아무것도 하지 않음
     */

    public static void main(String[] args) {
        List<User> users = initializeUsers();
        Optional<User> kim = getUserByName(users, "kim");

        kim.ifPresent(u->System.out.println(u.getName().toUpperCase()));
    }

    public static List<User> initializeUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("조건희",28));
        users.add(new User("이순신",102));
        users.add(new User("김유신",70));
        users.add(new User("kim",70));
        return users;
    }

    public static Optional<User> getUserByName(List<User> users, String name){
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }




}
