package com.kodilla.patterns2.adapter.bookclassifier.librarya;

public class BookA {

    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signature;

    public BookA(final String author, final String title,
                 final int publicationYear, final String signature) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.signature = signature;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getSignature() {
        return signature;
    }
}