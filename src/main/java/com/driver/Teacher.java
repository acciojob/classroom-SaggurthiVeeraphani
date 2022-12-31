package com.driver;

public class Teacher {

    public String getName() {
        return name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getAge() {
        return age;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int numberOfStudents;

    private int age;

    public Teacher() {

    }

    public Teacher(String name, int numberOfStudents, int age) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.age = age;
    }
}