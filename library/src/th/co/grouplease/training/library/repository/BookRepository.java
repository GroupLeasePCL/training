package th.co.grouplease.training.library.repository;

import th.co.grouplease.training.library.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getBooks();
    void saveBooks(List<Book> books);
}
