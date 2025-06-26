package optional.practice.practice01;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Practice01Main {
    /**   1. 기본 조회 및 기본 값 처리
     *
     *    유저정보를 DB에서 조회했는데, 없을 수 있다.
     *    유저가 없으면 "GUEST" 이름으로 간주한다.
     */

    public static void main(String[] args) {
        List<User> users = initializeUsers();
        User user1 = getUserByName(users, "김");
        System.out.println("user1 = " + user1);
    }

    public static List<User> initializeUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("조건희",28));
        users.add(new User("이순신",102));
        users.add(new User("김유신",70));
        return users;
    }

    public static User getUserByName(List<User> users, String name){
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(new User("GUEST"));

    }


}
