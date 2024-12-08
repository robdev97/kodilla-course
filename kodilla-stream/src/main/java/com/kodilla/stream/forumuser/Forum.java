package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//StreamMain6 Zadanie: funkcyjny spacer po liście użytkowników forum
public class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {

        userList.add(new ForumUser(398457, "Robert", 'M', LocalDate.of(1997, 01, 11), 22));
        userList.add(new ForumUser(109288, "Julie", 'F', LocalDate.of(2000, 05, 16), 15));
        userList.add(new ForumUser(908776, "Jack", 'M', LocalDate.of(1998, 11, 05), 32));
        userList.add(new ForumUser(635837, "Patricia", 'F', LocalDate.of(1999, 02, 28), 17));
        userList.add(new ForumUser(590715, "Mauricio", 'M', LocalDate.of(1997, 12, 06), 27));
        userList.add(new ForumUser(658697, "Ellys", 'F', LocalDate.of(2002, 10, 17), 19));

    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);


    }


}
