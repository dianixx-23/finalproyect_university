package com.globant.models.data;

import com.globant.models.inheritance.Person;

import java.util.List;

public class Student extends Person {

    private int studentNumber;
    private int age;
    private List<Subject> subjectListStudent;

    public Student(String name, String lastName, int numberId, int studentNumber, int age) {
        super(name, lastName, numberId);
        this.studentNumber = studentNumber;
        this.age = age;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Subject> getSubjectListStudent() {
        return subjectListStudent;
    }

    public void setSubjectListStudent(List<Subject> subjectListStudent) {
        this.subjectListStudent = subjectListStudent;
    }

    @Override
    public String toString() {
        return " Student# : " + studentNumber +
                ", Name: " + super.getName() +
                ", Last Name: " + super.getLastName() +
                ", ID: " + super.getNumberId() +
                ", Age: " + age;
    }
}
