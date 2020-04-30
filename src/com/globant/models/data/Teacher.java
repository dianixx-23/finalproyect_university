package com.globant.models.data;

import com.globant.models.inheritance.Person;

public class Teacher extends Person {

    private int teacherNumber;
    private String typeTeacher;

    public Teacher(String name, String lastName, int numberId, int teacherNumber, String typeTeacher) {
        super(name, lastName, numberId);
        this.teacherNumber = teacherNumber;
        this.typeTeacher = typeTeacher;
    }

    public int getTeacherNumber() {
        return teacherNumber;
    }

    public String getTypeTeacher() {
        return typeTeacher;
    }


    @Override
    public String toString() {
        return "Teacher # = " + teacherNumber +
               ", Name = " + super.getName() +
                ", Last Name = "  + super.getLastName() + "\n" +
                "Number ID = " + super.getNumberId() +
                ", Type = " + typeTeacher;
    }
}
