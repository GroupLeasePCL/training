package th.co.grouplease.training.library.domain;

import java.time.LocalDate;

public class Book {

    private String id;
    private String name;
    private LocalDate registeredDate;

    public Book(String id, String name, LocalDate registeredDate) {
        this.id = id;
        this.name = name;
        this.registeredDate = registeredDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }
}
