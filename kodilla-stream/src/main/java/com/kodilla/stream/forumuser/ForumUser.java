package com.kodilla.stream.forumuser;

import java.time.LocalDate;
////StreamMain6 Zadanie: funkcyjny spacer po liście użytkowników forum
public class ForumUser {

    private final int login;
    private final String username;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int publishedPosts;

    public ForumUser(final int login, final String username, final char sex, final LocalDate dateOfBirth,
                     final int publishedPosts) {
        this.login = login;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.publishedPosts = publishedPosts;
    }

    public int getLogin() {
        return login;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPublishedPosts() {
        return publishedPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "login=" + login +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", publishedPosts=" + publishedPosts +
                '}';
    }
}
