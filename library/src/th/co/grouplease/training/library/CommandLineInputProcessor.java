package th.co.grouplease.training.library;

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

    private void processInput(final Scanner scanner){
        System.out.println("Menu available:");
        System.out.println("1: quit (quit)");
        System.out.println("2: print books (printBooks)");
        System.out.println("3: print users (printUsers)");

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
            default:
                System.out.println("Input to be handled: " + userInput);
                break;
        }
    }

    private void quit(){
        isRunning = false;
    }

    private void printBooks(){
        for(var book : library.getBooks()){
            System.out.println("Book id: " + book.getId() + " name: " + book.getName() + " registered date: " + book.getRegisteredDate());
        }
    }

    private void printUsers(){
        for(var user : library.getUsers()){
            System.out.println("User id: " + user.getId() + " name: " + user.getName() + " registered date: " + user.getRegisteredDate());
        }
    }
}
