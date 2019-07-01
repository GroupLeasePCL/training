package th.co.grouplease.training.library.repository;

import th.co.grouplease.training.library.domain.Book;
import th.co.grouplease.training.library.exception.NotImplementedException;

import java.util.List;

public class BookFileRepository implements BookRepository {

    @Override
    public List<Book> getBooks() {
        throw new NotImplementedException();
    }

    @Override
    public void saveBooks(List<Book> books) {
        throw new NotImplementedException();
    }
}
