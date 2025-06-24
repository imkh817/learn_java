package lambda.basic;

import java.util.List;

public class BasicMain {
    public static void main(String[] args) {
        /**
         *  Java 8 이전에는 기능을 멤서드 인자로 전달할 때 아래와 같이 익명 클래스를 사용했다.
         *  익명 클래스는 클래스 선언과 인스턴스 생성이 결합되어 있어 코드가 장황하다.
         *
         */
        MyLambdaFunction myLambdaFunction1 = new MyLambdaFunction() {
            @Override
            public int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        /**
         * 익명 클래스는 코드 작성과 가독성 측면에서 불편하므로 자바에서는 이를 간결하게 대체하기 위해 람다식을 도입했다.
         */
        MyLambdaFunction myLambdaFunction = (int a, int b) -> a > b ? a : b;
        System.out.println("myLambdaFunction = " + myLambdaFunction.max(3, 5));


    }
}
