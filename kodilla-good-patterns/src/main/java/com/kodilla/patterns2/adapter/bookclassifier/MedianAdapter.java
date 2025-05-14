package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.BookA;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookB;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends Statistics implements Classifier {

    @Override
    public int publicationYearMedian(Set<BookA> bookSet) {
        Map<BookSignature, BookB> booksMap = new HashMap<>();

        for (BookA bookA : bookSet) {
            BookSignature signature = new BookSignature(bookA.getSignature());
            BookB bookB =
                    new BookB(
                            bookA.getAuthor(),
                            bookA.getTitle(),
                            bookA.getPublicationYear()
                    );
            booksMap.put(signature, bookB);
        }

        return medianPublicationYear(booksMap);
    }
}