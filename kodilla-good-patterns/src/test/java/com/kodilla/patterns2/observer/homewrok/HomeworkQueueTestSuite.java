package com.kodilla.patterns2.observer.homewrok;

import com.kodilla.patterns2.observer.homework.HomeworkQueue;
import com.kodilla.patterns2.observer.homework.Mentor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HomeworkQueueTestSuite {

    @Test
    void HomeworkTestSuite() {
        // Given
        HomeworkQueue robertTasks = new HomeworkQueue("Robert");
        HomeworkQueue pawelTasks = new HomeworkQueue("Pawel");
        HomeworkQueue kacperTasks = new HomeworkQueue("Kacper");

        Mentor mentorPawel = new Mentor("Pawel");
        Mentor mentorPiotr = new Mentor("Piotr");

        robertTasks.registerObserver(mentorPawel);
        pawelTasks.registerObserver(mentorPawel);
        kacperTasks.registerObserver(mentorPiotr);

        // When
        robertTasks.addTask("Task 1");
        pawelTasks.addTask("Task 2");
        robertTasks.addTask("Task 3");
        kacperTasks.addTask("Task 4");
        kacperTasks.addTask("Task 5");

        // Then
        assertEquals(3, mentorPawel.getUpdateCount());
        assertEquals(2, mentorPiotr.getUpdateCount());
    }
}