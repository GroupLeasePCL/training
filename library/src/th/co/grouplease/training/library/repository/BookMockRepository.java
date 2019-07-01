package th.co.grouplease.training.library.repository;

import th.co.grouplease.training.library.domain.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookMockRepository implements BookRepository {

    private List<Book> books = new ArrayList<>();

    public BookMockRepository(){
        books.add(new Book(UUID.randomUUID().toString(), "Book4", "Horror", LocalDate.now()));
        books.add(new Book(UUID.randomUUID().toString(), "Book3", "Horror", LocalDate.now()));
        books.add(new Book(UUID.randomUUID().toString(), "Book2", "Education", LocalDate.now()));
        books.add(new Book(UUID.randomUUID().toString(), "Book1", "Education", LocalDate.now()));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void saveBooks(List<Book> books) {
        if(books == null){
            throw new NullPointerException("books cannot be null");
        } else {
            this.books = books;
        }
    }
}
