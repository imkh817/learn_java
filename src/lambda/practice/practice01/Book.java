package lambda.practice.practice01;


import java.util.Comparator;

public class Book implements Comparator<Book> {
    private String title;
    private int price;
    private String genre;

    public Book(String title, int price, String genre) {
        this.title = title;
        this.price = price;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public int compare(Book book, Book t1) {
        return book.getPrice() - t1.getPrice();
    }
}
