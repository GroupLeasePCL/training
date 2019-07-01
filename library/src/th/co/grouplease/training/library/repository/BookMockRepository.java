package th.co.grouplease.training.library.repository;

import th.co.grouplease.training.library.domain.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookMockRepository implements BookRepository {

    private List<Book> books = new ArrayList<>();

    public BookMockRepository(){
        books.add(new Book(UUID.randomUUID().toString(), "Book1", LocalDate.now()));
        books.add(new Book(UUID.randomUUID().toString(), "Book2", LocalDate.now()));
        books.add(new Book(UUID.randomUUID().toString(), "Book3", LocalDate.now()));
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
