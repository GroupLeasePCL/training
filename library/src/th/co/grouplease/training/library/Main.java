package th.co.grouplease.training.library;

import th.co.grouplease.training.library.repository.BookMockRepository;
import th.co.grouplease.training.library.repository.UserMockRepository;

public class Main {

    public static void main(String[] args) {
        CommandLineInputProcessor
                .createWith(new Library(new UserMockRepository(), new BookMockRepository()))
                .start();
    }
}
