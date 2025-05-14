package com.kodilla.patterns2.adapter.classifier;

import com.kodilla.patterns2.adapter.bookclassifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.BookA;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        // Given
        Set<BookA> books = new HashSet<>();
        books.add(new BookA("Author 1", "Title 1", 2001, "SIG1"));
        books.add(new BookA("Author 2", "Title 2", 1999, "SIG2"));
        books.add(new BookA("Author 3", "Title 3", 2010, "SIG3"));
        books.add(new BookA("Author 4", "Title 4", 2005, "SIG4"));
        books.add(new BookA("Author 5", "Title 5", 2003, "SIG5"));

        MedianAdapter medianAdapter = new MedianAdapter();

        // When
        int median = medianAdapter.publicationYearMedian(books);

        // Then
        assertEquals(2003, median);
    }
}