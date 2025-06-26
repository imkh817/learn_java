package lambda.functionalinterface.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalMain {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new ComicBook("메이플 스토리", 10000));
        books.add(new Magazine("잡지",5000));
        books.add(new Book("요리 책", 13000));

        BookService bookService = new BookService();
        List<Book> filterdBooks = bookService.filterPriceMoreThan(books, book -> book.getPrice() > 7000);
        System.out.println("filterdBooks = " + filterdBooks);

        Predicate<Book> priceMoreThan = book -> book.getPrice() > 3000;
        Predicate<Book> priceLessThan = book -> book.getPrice() < 6000;
        Predicate<Book> priceGreaterThan = priceMoreThan.and(priceLessThan);

        List<Book> filteredBooks = bookService.filterWithPrice(books, priceGreaterThan);
        System.out.println("filteredBooks = " + filteredBooks);
    }
}
