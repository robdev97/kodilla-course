package com.kodilla.testing.library;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for( int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n,"Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Test
    void theListBookWithConditionReturnList() {
        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    void theListBookWithConditionMoreThan20() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBookWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        //Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    void testListBookInHandsOfWithoutBorrowedBooks() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Mangus", "Carlsen", "97011195874");
        when(libraryDatabaseMock.listBookInHandsOf(libraryUser))
                .thenReturn(new ArrayList<>());
        //When
        List<Book> borrowedBook = bookLibrary.listBookInHandsOf(libraryUser);

        //Then
        assertEquals(0, borrowedBook.size());

    }

    @Test
    void testListBookInHandsOfBorrowedOneBook() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Mangus", "Carlsen", "97011195874");
        List<Book> borrowedBookList = new ArrayList<>();
        Book book1 = new Book("whatever", "someone out here", 2024);
        borrowedBookList.add(book1);
        when(libraryDatabaseMock.listBookInHandsOf(libraryUser))
                .thenReturn(borrowedBookList);

        //When
        List<Book> bookListResult = bookLibrary.listBookInHandsOf(libraryUser);
        //Then
        assertEquals(1, bookListResult.size());
        assertEquals("whatever", bookListResult.get(0).getTitle());
    }

    @Test
    void testListBookInHandsOfBorrowedFive() {
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser = new LibraryUser("Mangus", "Carlsen", "97011195874");
        List<Book> borrowedFiveBooks = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBookInHandsOf(libraryUser))
                .thenReturn(borrowedFiveBooks);
        //When
        List<Book> BookListResult = bookLibrary.listBookInHandsOf(libraryUser);

        //Then
        assertEquals(5, BookListResult.size());
        assertEquals("Title 1", BookListResult.get(0).getTitle());
        assertEquals("Title 5", BookListResult.get(4).getTitle());
    }
}
