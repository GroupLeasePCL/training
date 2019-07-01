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
        System.out.println("Menu available: ...");
        // TODO: implement input processor
    }

    private void stop(){
        isRunning = false;
    }
}
