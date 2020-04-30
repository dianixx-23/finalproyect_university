package com.globant.models.typeteacher;

import com.globant.models.data.Teacher;
import com.globant.models.inheritance.Employee;

public class PartTmeTeacher extends Teacher implements Employee {

    private int salaryBase;
    private String typeTeacher;
    private double hoursWeek;
    private double salaryTotal;

    public PartTmeTeacher(String name, String lastName, int numberId, int teacherNumber, int salaryBase, String typeTeacher, double hoursWeek) {
        super(name, lastName, numberId, teacherNumber,typeTeacher);
        this.salaryBase = salaryBase;
        this.typeTeacher = typeTeacher;
        this.hoursWeek = hoursWeek;
    }

    public double getSalaryPT() {
        return salaryTotal;
    }

    public void setSalaryPT(double salaryPT) {
        this.salaryTotal = salaryPT;
    }

    public void setHoursWeek(double hoursWeek) {
        this.hoursWeek = hoursWeek;
    }

    public void calculateSalary() {
        this.salaryTotal = salaryBase * hoursWeek;
    }

    @Override
    public String toString() {
        return " Teacher#: " + getTeacherNumber() +
                ", Name: " + super.getName() +
                ", Last Name: "  + super.getLastName() + "\n" +
                " , ID: " + super.getNumberId() +
                ", Type: " + typeTeacher +
                ", Salary Base: " + salaryBase + "\n" +
                " , Hours per Week: " + hoursWeek +
                ", Salary Total: " + salaryTotal;
    }
}
