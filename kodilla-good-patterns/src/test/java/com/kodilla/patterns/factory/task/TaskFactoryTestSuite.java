package com.kodilla.patterns.factory.task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testShoppingTaskCreation() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task task = factory.createTask(TaskFactory.SHOPPING);

        // Then
        assertEquals("Shopping task", task.getTaskName());
        assertFalse(task.isTaskExecuted());
        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testPaintingTaskCreation() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task task = factory.createTask(TaskFactory.PAINTING);

        // Then
        assertEquals("Painting task", task.getTaskName());
        assertFalse(task.isTaskExecuted());
        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testDrivingTaskCreation() {
        // Given
        TaskFactory factory = new TaskFactory();

        // When
        Task task = factory.createTask(TaskFactory.DRIVING);

        // Then
        assertEquals("Driving task", task.getTaskName());
        assertFalse(task.isTaskExecuted());
        task.executeTask();
        assertTrue(task.isTaskExecuted());
    }
}