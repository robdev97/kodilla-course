package com.kodilla.patterns2.observer.homework;

public class Mentor implements HomeworkObserver {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(HomeworkQueue homeworkQueue) {
        System.out.println("Mentor " + name + ": New task in queue from student " +
                homeworkQueue.getStudentName() + " (total: " + homeworkQueue.getTasks().size() + ")");
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
