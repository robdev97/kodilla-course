package com.kodilla.spring.reader;

public final class Reader {

    final Book theBook;

    public Reader(final Book book) {
        theBook = book;
    }

    public void read() {
        System.out.println("Reading :" + theBook.getTitle());
    }
}
