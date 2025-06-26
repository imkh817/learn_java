package optional.basic;

import java.util.Optional;

public class BasicFcuntion {
    public static void main(String[] args) {
        // null이 아닌 Optional 값 반환
        Optional<String> optional = Optional.of("hello");
        String s = "hello2";
        Optional<String> optional2 = Optional.ofNullable(getName());

        if(optional.isPresent()) {
            System.out.println(optional.get());
        }

    }
    
    public static String getName(){
        return "hello";
    }
}
