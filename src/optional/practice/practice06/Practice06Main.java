package optional.practice.practice06;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Practice06Main {
    /**   6. orElseThrow()로 예외 처리
     *
     *    유저 정보를 이름으로 조회했는데, 존재하지 않으면 예외를 던져야 한다.
     *    예외 메시지는 "존재하지 않는 사용자입니다"
     *
     */

    public static void main(String[] args) {
        List<User> users = initializeUsers();

        String name = "k";
        User user = users.stream().filter(u -> name.equals(u.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));

        System.out.println("user = " + user);


    }

    public static List<User> initializeUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("조건희",28, Optional.of("rjs123@naver.com")));
        users.add(new User("이순신",102, Optional.empty()));
        users.add(new User("김유신",70, Optional.empty()));
        users.add(new User("kim",70, Optional.empty()));
        return users;
    }
}
