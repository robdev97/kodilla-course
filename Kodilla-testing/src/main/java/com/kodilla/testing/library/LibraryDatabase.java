package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {

    List<Book> listBooksWithCondition(String titleFragment);

    List<Book> listBookInHandsOf(LibraryUser libraryUser);

    boolean rentABook(LibraryUser libraryUser, Book book);

    int returnBooks (LibraryUser libraryUser);
}
