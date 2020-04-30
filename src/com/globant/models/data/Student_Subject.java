package com.globant.models.data;

public class Student_Subject {

    private int studentNumber;
    private int subjectNumber;

    public Student_Subject(int studentNumber, int subjectNumber){
        this.studentNumber = studentNumber;
        this.subjectNumber = subjectNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(int subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    @Override
    public String toString() {
        return "studentNumber=" + studentNumber +
                ", subjectNumber=" + subjectNumber;
    }
}
