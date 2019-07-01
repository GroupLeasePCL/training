package th.co.grouplease.training.library;

import th.co.grouplease.training.library.comparator.BookComparator;
import th.co.grouplease.training.library.domain.Book;
import th.co.grouplease.training.library.domain.User;
import th.co.grouplease.training.library.repository.BookRepository;
import th.co.grouplease.training.library.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Library {

    // Inner classes to report status of borrowing and returning
    public class BorrowingBookResult {
        private boolean isSucceeded;
        private String error;

        BorrowingBookResult(boolean isSucceeded, String error) {
            this.isSucceeded = isSucceeded;
            this.error = error;
        }

        public boolean isSucceeded() {
            return isSucceeded;
        }

        public String getError() {
            return error;
        }
    }

    public class ReturningBookResult {
        private boolean isSucceeded;
        private String error;

        public ReturningBookResult(boolean isSucceeded, String error) {
            this.isSucceeded = isSucceeded;
            this.error = error;
        }

        public boolean isSucceeded() {
            return isSucceeded;
        }

        public String getError() {
            return error;
        }
    }

    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public Library(UserRepository userRepository, BookRepository bookRepository){
        books.addAll(bookRepository.getBooks());
        users.addAll(userRepository.getUsers());
    }

    // Book APIs
    public Book registerBook(String name, String category){
        Book result = new Book(UUID.randomUUID().toString(), name, category, LocalDate.now(), null, null);
        books.add(result);
        return result;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void sortBooks(){
        books.sort(new BookComparator());
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

    public BorrowingBookResult borrowBook(String bookId, String userId){
        // find borrowing user by id
        User borrowerUser = null;
        for(var user : users){
            if(user.getId().contains(userId)){
                borrowerUser = user;
            }
        }

        if(borrowerUser == null){
            return new BorrowingBookResult(false, "Cannot find borrowing user by id: " + userId);
        }

        // find book by id
        for(var book : books){
            if(book.getId().contains(bookId)){
                if(book.getBorrower() == null){
                    book.setBorrower(borrowerUser);
                    book.setBorrowedDate(LocalDate.now());
                    return new BorrowingBookResult(true, null);
                } else {
                    return new BorrowingBookResult(false, "Book has been borrowed");
                }
            }
        }
        return new BorrowingBookResult(false, "Cannot find book by id: " + bookId);
    }

    public ReturningBookResult returnBook(String bookId){
        // find book by id
        for(var book : books){
            if(book.getId().contains(bookId)){
                if(book.getBorrower() == null){
                    return new ReturningBookResult(false, "Cannot return book as it wasn't borrowed");
                } else {
                    book.setBorrowedDate(null);
                    book.setBorrower(null);
                    return new ReturningBookResult(true, null);
                }
            }
        }
        return new ReturningBookResult(false, "Cannot find book by id: " + bookId);
    }

    public List<Book> getBorrowedBooks(){
        var result = new ArrayList<Book>();

        for(var book : books){
            if(book.getBorrower() != null){
                result.add(book);
            }
        }

        return result;
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
