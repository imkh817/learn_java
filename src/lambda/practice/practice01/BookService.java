package lambda.practice.practice01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookService <T extends Book> {
    public List<T> books = new ArrayList<>();

    public void addBooks(T book) {
        books.add(book);
    }

    public List<? extends Book> recommendedBooks(BookFilter filter) {
        return books.stream()
                .filter(filter::mathces)
                .collect(Collectors.toList());
    }

    public List<? extends Book> recommendedBooksWithPredicate(Predicate<Book> filter) {
        return books.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    // 제목
    public List<String> recommendedBooksWithFunction(Function<Book, String> filter) {
        return books.stream()
                .map(filter)
                .collect(Collectors.toList());
    }

    public List<? super Book> transferTo() {
        return new ArrayList<>(books);
    }

    public List<? extends Book> sort(Comparator<? super Book> comparator) {
        books.sort(comparator);
        return books;
    }

}
