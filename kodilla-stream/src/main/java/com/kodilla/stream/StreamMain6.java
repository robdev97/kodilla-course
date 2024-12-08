package com.kodilla.stream;


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;


//Zadanie: funkcyjny spacer po liście użytkowników forum
public class StreamMain6 {


    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> usersResult = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() >= 20)
                .filter(user -> user.getPublishedPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getLogin, user -> user));

        usersResult.forEach((id, user) -> System.out.println(id + ": " + user));
    }

}
