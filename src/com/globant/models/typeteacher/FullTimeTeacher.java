package com.globant.models.typeteacher;

import com.globant.models.data.Teacher;
import com.globant.models.inheritance.Employee;

public class FullTimeTeacher extends Teacher implements Employee {

    private int salaryBase;
    private String typeTeacher;
    private double experienceYears;
    private double salaryTotal;

    public FullTimeTeacher(String name, String lastName, int numberId, int teacherNumber, int salaryBase, String typeTeacher, double experienceYears) {
        super(name, lastName, numberId, teacherNumber, typeTeacher);
        this.salaryBase = salaryBase;
        this.typeTeacher = typeTeacher;
        this.experienceYears = experienceYears;
    }


    @Override
    public void calculateSalary() { this.salaryTotal = salaryBase * 1.1 * experienceYears; }

    public double getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(double experienceYears) {
        this.experienceYears = experienceYears;
    }

    public double getSalaryFT() {
        return salaryTotal;
    }

    public void setSalaryFT(double salaryFT) {
        this.salaryTotal = salaryTotal;
    }

    public void getTeacherName (){super.getName();}

    public void getTeacherLastName (){super.getLastName();}

    @Override
    public String toString() {
        return " Teacher#: " + getTeacherNumber() +
                ", Name: " + super.getName() +
                ", Last Name: "  + super.getLastName() + "\n" +
                " , Number ID: " + super.getNumberId() +
                ", Type: " + typeTeacher +
                ", Salary Base: " + salaryBase + "\n" +
                " , Experience Years: " + experienceYears +
                ", Salary Total: " + salaryTotal;
    }
}
