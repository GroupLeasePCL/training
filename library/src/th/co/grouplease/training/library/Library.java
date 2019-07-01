package th.co.grouplease.training.library;

import th.co.grouplease.training.library.domain.Book;
import th.co.grouplease.training.library.domain.User;
import th.co.grouplease.training.library.repository.BookRepository;
import th.co.grouplease.training.library.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public Library(UserRepository userRepository, BookRepository bookRepository){
        books.addAll(bookRepository.getBooks());
        users.addAll(userRepository.getUsers());
    }

    // Book APIs
    public Book registerBook(String name){
        Book result = new Book(UUID.randomUUID().toString(), name, LocalDate.now());
        books.add(result);
        return result;
    }

    public List<Book> getBooks() {
        return books;
    }

    // User APIs
    public User registerUser(String name){
        User result = new User(UUID.randomUUID().toString(), name, LocalDate.now());
        users.add(result);
        return result;
    }

    public List<User> getUsers() {
        return users;
    }
}
