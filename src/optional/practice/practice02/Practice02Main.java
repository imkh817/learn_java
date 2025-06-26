package optional.practice.practice02;

import optional.practice.practice02.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Practice02Main {
    /**   2. map()으로 속성 꺼내기
     *
     *    유저정보를 DB에서 조회했는데 Optional로 감싸져 있음
     *    유저가 있으면 나이를 꺼내고 출력
     *    없으면 "나이 정보 없음" 출력
     */

    public static void main(String[] args) {
        List<User> users = initializeUsers();
        Optional<User> user = getUserByName(users, "조건희");
        user.map(User::getAge).ifPresentOrElse(System.out::println, () -> System.out.println("나이 정보 없음"));
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
