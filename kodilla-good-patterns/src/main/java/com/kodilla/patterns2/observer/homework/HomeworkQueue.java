package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue implements Observable {
    private final String studentName;
    private final List<String> tasks = new ArrayList<>();
    private final List<HomeworkObserver> observers = new ArrayList<>();

    public HomeworkQueue(String studentName) {
        this.studentName = studentName;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public void registerObserver(HomeworkObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (HomeworkObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(HomeworkObserver observer) {
        observers.remove(observer);
    }
}