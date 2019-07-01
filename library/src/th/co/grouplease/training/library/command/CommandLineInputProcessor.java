package th.co.grouplease.training.library.command;

import th.co.grouplease.training.library.Library;
import th.co.grouplease.training.library.domain.Book;

import java.util.Scanner;

public class CommandLineInputProcessor {

    private boolean isRunning;
    private final Library library;

    private CommandLineInputProcessor(Library library){
        this.library = library;
    }

    public static CommandLineInputProcessor createWith(Library library){
        return new CommandLineInputProcessor(library);
    }

    public void start(){
        isRunning = true;

        try(var scanner = new Scanner(System.in)){
            while(isRunning){
                processInput(scanner);
            }
        }
    }

    private void printMenus(){
        System.out.println("Menu available:");
        System.out.println("1: quit (quit)");
        System.out.println("2: print books (printBooks)");
        System.out.println("3: print users (printUsers)");
        System.out.println("4: search books (searchBooks)");
    }

    private void processInput(final Scanner scanner){
        printMenus();
        var userInput = scanner.nextLine().trim();
        switch (userInput) {
            case "quit":
                quit();
                break;
            case "printBooks":
                printBooks();
                break;
            case "printUsers":
                printUsers();
                break;
            case "searchBooks":
                System.out.println("Enter id:");
                var id = scanner.nextLine().trim();
                System.out.println("Enter name:");
                var name = scanner.nextLine().trim();
                System.out.println("Enter category:");
                var category = scanner.nextLine().trim();
                searchBooks(id, name, category);
                break;
            default:
                System.out.println("Input to be handled: " + userInput);
                break;
        }
    }

    private void searchBooks(String id, String name, String category) {
        var books = library.searchBooks(id, name, category);
        System.out.println("Matched books: " + books.size());
        for(var book: books){
            printBook(book);
        }
    }

    private void quit(){
        isRunning = false;
    }

    private void printBooks(){
        for(var book : library.getBooks()){
            printBook(book);
        }
    }

    private void printUsers(){
        for(var user : library.getUsers()){
            System.out.println("User id: " + user.getId() + " name: " + user.getName() + " registered date: " + user.getRegisteredDate());
        }
    }

    private void printBook(final Book book){
        System.out.println("Book id: " + book.getId() + " name: " + book.getName() + " category: " + book.getCategory() + " registered date: " + book.getRegisteredDate());
    }
}
