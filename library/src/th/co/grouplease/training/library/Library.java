package th.co.grouplease.training.library;

import th.co.grouplease.training.library.domain.Book;
import th.co.grouplease.training.library.domain.User;
import th.co.grouplease.training.library.repository.BookRepository;
import th.co.grouplease.training.library.repository.UserRepository;

import java.time.LocalDate;
import java.util.*;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public Library(UserRepository userRepository, BookRepository bookRepository){
        books.addAll(bookRepository.getBooks());
        users.addAll(userRepository.getUsers());
    }

    // Book APIs
    public Book registerBook(String name, String category){
        Book result = new Book(UUID.randomUUID().toString(), name, category, LocalDate.now());
        books.add(result);
        return result;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> searchBooks(String id, String name, String category){
        if(isStringNullOrEmpty(id) && isStringNullOrEmpty(name) && isStringNullOrEmpty(category))
            return new ArrayList<>();

        // search logic id && name && category
        var idResult = new ArrayList<Book>();
        var nameResult = new ArrayList<Book>();
        var categoryResult = new ArrayList<Book>();

        for(var book : books){
            if(!isStringNullOrEmpty(id) && book.getId().contains(id)){
                idResult.add(book);
            }

            if(!isStringNullOrEmpty(name) && book.getName().contains(name)){
                nameResult.add(book);
            }

            if(!isStringNullOrEmpty(category) && book.getCategory().contains(category)){
                categoryResult.add(book);
            }
        }

        if(!isStringNullOrEmpty(id) && !isStringNullOrEmpty(name) && !isStringNullOrEmpty(category)){
            idResult.retainAll(nameResult);
            idResult.retainAll(categoryResult);
            return idResult;
        } else if(!isStringNullOrEmpty(id) && !isStringNullOrEmpty(name)) {
            idResult.retainAll(nameResult);
            return idResult;
        } else if(!isStringNullOrEmpty(name) && !isStringNullOrEmpty(category)){
            nameResult.retainAll(categoryResult);
            return nameResult;
        } else if(!isStringNullOrEmpty(id) && !isStringNullOrEmpty(category)){
            idResult.retainAll(categoryResult);
            return idResult;
        } else if(!isStringNullOrEmpty(id)){
            return idResult;
        } else if(!isStringNullOrEmpty(name)){
            return nameResult;
        } else { //!isStringNullOrEmpty(category)
            return categoryResult;
        }
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

    private boolean isStringNullOrEmpty(String str){
        return str == null || str.isEmpty();
    }
}
