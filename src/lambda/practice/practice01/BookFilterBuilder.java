package lambda.practice.practice01;

import java.util.function.Predicate;

public class BookFilterBuilder {
    private Predicate<Book> predicate;

    public BookFilterBuilder() {
        this.predicate = book -> true; // 초기에는 항상 true (조건 없음)
    }

    public BookFilterBuilder and(Predicate<Book> predicate) {
        this.predicate = this.predicate.and(predicate);
        return this;
    }

    public BookFilterBuilder or(Predicate<Book> predicate) {
        this.predicate = this.predicate.or(predicate);
        return this;
    }

    public Predicate<Book> build() {
        return predicate;
    }


}
