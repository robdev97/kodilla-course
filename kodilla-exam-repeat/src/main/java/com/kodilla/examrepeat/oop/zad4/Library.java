package com.kodilla.examrepeat.oop.zad4;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private String name;
    private List<Book> books;
    private List<User> users;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book.getTitle() + " by " + book.getAuthor());
    }

    public void displayAvailableBooks() {
        System.out.println("Available books: " + name);
        boolean hasAvailableBooks = false;
        for (Book book : books) {
            if(book.isAvailable()) {
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor());
                hasAvailableBooks = true;
            }
        }
        if (!hasAvailableBooks) {
            System.out.println("No books available");
        }
    }
    public void registerUser(User user) {
        users.add(user);
        System.out.println("Registered: " + user.getName());
    }

    public boolean lendBook(User user, Book book) {
        if (users.contains(user) && books.contains(book)) {
            if (user.borrowBook(book)) {
                System.out.println(user.getName() + " borrowed " + book.getTitle());
                return true;
            } else {
                System.out.println("Book: \"" + book.getTitle() + "\" is not available.");
            }
        } else {
            System.out.println("User or Book not found");
        }
        return false;
    }

    public boolean returnBook(User user, Book book) {
        if (users.contains(user) && books.contains(book)) {
            if (user.borrowBook(book)) {
                System.out.println(user.getName() + " returned " + book.getTitle());
                return true;
            } else {
                System.out.println("User " + user.getName() + " did not borrow this book.");
            }
        } else {
            System.out.println("User or Book not found");
        }
        return false;
    }
}
