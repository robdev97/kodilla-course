package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSgaringStrategies() {
        //Given
        User millenial = new Millenials("Mr Millenial");
        User yGen = new YGeneration("Mr Y Gen");
        User GenZ = new ZGeneration("Mr Gen Z");

        //When
        String millenialShare = millenial.sharePost();
        System.out.println("Mr Millenial sharing post on " + millenialShare);
        String yGenShare = yGen.sharePost();
        System.out.println("Y Gen sharing post on " + yGenShare);
        String GenZShare = GenZ.sharePost();
        System.out.println("Gen Z sharing post on " + GenZShare);

        //Then
        assertEquals("Facebook", millenialShare);
        assertEquals("Twitter", yGenShare);
        assertEquals("Snapchat", GenZShare);


    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User millenial = new Millenials("Mr Millenial");

        //When
        String defaultShare = millenial.sharePost();
        System.out.println("Mr Millenial sharing post on " + defaultShare);
        millenial.setSocialPublisher(new TwitterPublisher());
        String newShare = millenial.sharePost();
        System.out.println("Mr Millenial sharing now post on " + newShare);

        //When
        assertEquals("Facebook", defaultShare);
        assertEquals("Twitter", newShare);



    }
}
