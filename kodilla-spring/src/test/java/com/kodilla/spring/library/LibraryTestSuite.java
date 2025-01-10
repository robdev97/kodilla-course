package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
public class LibraryTestSuite {

    @Autowired
    private Library library;

    @Test
    void testLoadFromDb() {
        //Given

        //When
        library.loadFromDb();

        //Then

    }

    @Test
    void testSaveToDb() {
        //Given

        //When
        library.saveToDb();

        //Then

    }
}
