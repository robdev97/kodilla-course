package com.kodilla.examrepeat.oop.zad4;

public class App {

    public static void main(String[] args) {

        Library library = new Library("Public Library");

        Book book1 = new Book("first book", "someone who wrote", 1995);
        Book book2 = new Book("second book", "someone who wrote", 1997);
        Book book3 = new Book("third book", "someone who wrote", 1999);


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        User user1 = new User("Robert");
        User user2 = new User("Amanda");

        library.registerUser(user1);
        library.registerUser(user2);

        library.displayAvailableBooks();

        library.returnBook(user1, book1);

        library.displayAvailableBooks();
    }
}
