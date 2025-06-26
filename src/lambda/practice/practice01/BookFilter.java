package lambda.practice.practice01;

import java.util.List;

@FunctionalInterface
public interface BookFilter {

    boolean mathces(Book book);

    // 기본 메서드로 필터 조합 기능 추가
    default BookFilter and(BookFilter other) {
        return book -> this.mathces(book) && other.mathces(book);
    }

    default BookFilter or(BookFilter other) {
        return book -> this.mathces(book) || other.mathces(book);
    }


}
