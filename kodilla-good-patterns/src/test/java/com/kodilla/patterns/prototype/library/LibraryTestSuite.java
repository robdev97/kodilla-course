package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LibraryTestSuite {

    @Test
    void testGetBooks() throws CloneNotSupportedException {
        //Given
        Library library = new Library("Library number one");
        library.getBooks().add(new Book("Book 1", "Author 1", LocalDate.of(2020, 5, 18)));
        library.getBooks().add(new Book("Book 2", "Author 2", LocalDate.of(2016, 12, 2)));
        library.getBooks().add(new Book("Book 3", "Author 3", LocalDate.of(2024, 1, 27)));


        Library clonedLibrary = library.shallowCopy();
        clonedLibrary.setName("Library number two");

        Library deepClonedLibrary = library.deepCopy();
        deepClonedLibrary.setName("Library number three");

        //When
        library.getBooks().add(new Book("Book 4", "Author 4", LocalDate.of(2004, 4, 4)));

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(4, library.getBooks().size());
        assertEquals(4, clonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
        assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }
}