package th.co.grouplease.training.library.domain;

import java.time.LocalDate;

public class Book {

    private String id;
    private String name;
    private String category;
    private LocalDate registeredDate;
    private User borrower;
    private LocalDate borrowedDate;

    public Book(String id, String name, String category, LocalDate registeredDate, User borrower, LocalDate borrowedDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.registeredDate = registeredDate;
        this.borrower = borrower;
        this.borrowedDate = borrowedDate;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }
}
