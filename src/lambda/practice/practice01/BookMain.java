package lambda.practice.practice01;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class BookMain {
    public static void main(String[] args) {
        BookService<Book> bookService = new BookService<>();
        initializeSampleBooks(bookService);
        runCustomFilter(bookService);
        runPredicateFilter(bookService);
        sortBooksByPriceDesc(bookService);
        runFilterWithBuilder(bookService);
        extractBookTitle(bookService);
    }

    public static void initializeSampleBooks(BookService<Book> bookService) {
        bookService.addBooks(new Book("A1", 1000,"A"));
        bookService.addBooks(new Book("A2", 1500,"AA"));
        bookService.addBooks(new Novel("B1", 3000,"B"));
        bookService.addBooks(new Novel("B2", 3500,"BB"));
        bookService.addBooks(new ScienceBook("C1", 5000,"C"));
        bookService.addBooks(new ScienceBook("C2", 5500,"CC"));
    }

    // BookFilter 기반 추천 실행
    public static void runCustomFilter(BookService<Book> bookService) {
        BookFilter cheap = book -> book.getPrice() <= 4000;
        BookFilter genreAA = book -> book.getGenre().equals("AA");
        BookFilter filter = cheap.and(genreAA);
        List<? extends Book> result = bookService.recommendedBooks(filter);
        System.out.println("📌 Custom BookFilter 추천 결과: " + result);
    }

    // Predicate<Book> 기반 추천 실행
    public static void runPredicateFilter(BookService<Book> bookService) {
        Predicate<Book> expensive = book -> book.getPrice() < 4000;
        Predicate<Book> genreAA = book -> book.getGenre().equals("AA");

        Predicate<Book> combined = expensive.and(genreAA);
        List<? extends Book> result = bookService.recommendedBooksWithPredicate(combined);
        System.out.println("📌 Predicate<Book> 추천 결과: " + result);
    }

    // Comparator<Book> 사용한 가격 정렬
    public static void sortBooksByPriceDesc(BookService<Book> bookService) {
        Comparator<? super Book> byPriceDesc = (b1, b2) -> b2.getPrice() - b1.getPrice();
        List<? extends Book> sorted = bookService.sort(byPriceDesc);
        System.out.println("📌 가격 내림차순 정렬 결과: " + sorted);
    }

    // BookFilterBuilder로 동적 필터 조합
    public static void runFilterWithBuilder(BookService<Book> bookService) {
        Predicate<Book> isCheap = book -> book.getPrice() < 10000;
        Predicate<Book> isGenreBB = book -> book.getGenre().equals("BB");

        BookFilterBuilder builder = new BookFilterBuilder();
        Predicate<Book> filter = builder.and(isCheap).and(isGenreBB).build();

        List<? extends Book> result = bookService.recommendedBooksWithPredicate(filter);
        System.out.println("📌 Builder 필터 추천 결과: " + result);
    }

    // Function<Book,String> 기반 제목 추출
    public static void extractBookTitle(BookService<Book> bookService) {
        List<String> titles = bookService.recommendedBooksWithFunction(Book::getTitle);
        System.out.println("📌 추천 도서 제목 리스트: " + titles);
    }

}
