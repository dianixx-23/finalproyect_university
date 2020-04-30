package com.globant.models.data;

import java.util.List;

public class Subject {

    private int subjectNumber;
    private String nameSubject;
    private int classroom;
    private int teacherAssigned;
    private List<Student> studentList;

    public Subject(int subjectNumber, String nameSubject, int classroom, int teacherAssigned) {
        this.subjectNumber = subjectNumber;
        this.nameSubject = nameSubject;
        this.classroom = classroom;
        this.teacherAssigned = teacherAssigned;
    }


    public int getSubjectNumber() {
        return subjectNumber;
    }

    public void setSubjectNumber(int subjectNumber) {
        this.subjectNumber = subjectNumber;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getTeacherAssigned() {
        return teacherAssigned;
    }

    public void setTeacherAssigned(int teacherAssigned) {
        this.teacherAssigned = teacherAssigned;
    }

    @Override
    public String toString() {
        return  " Subject#: " + subjectNumber +
                ", Name: " + nameSubject +
                ", Classroom: " + classroom;
    }
}
