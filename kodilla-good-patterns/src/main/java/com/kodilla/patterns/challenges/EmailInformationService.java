package com.kodilla.patterns.challenges;

public class EmailInformationService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("Sending email to: " + user.getEmail());
    }
}