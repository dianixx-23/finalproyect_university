package com.globant.util;

import com.globant.models.data.Student;
import com.globant.models.data.Student_Subject;
import com.globant.models.data.Subject;
import com.globant.models.typeteacher.FullTimeTeacher;
import com.globant.models.typeteacher.PartTmeTeacher;

import java.util.ArrayList;
import java.util.List;


public class Ini {

    private static Common common = new Common();

    public static List<Student> initStudent(){
        List<String> lines = common.readFile("student.txt");
        List<Student> studentList = new ArrayList<>();

        for(String line:lines){
            String[] values = line.split(",");

            Student student = new Student(values[0], values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4]));
            studentList.add(student);
        }
        return studentList;
    }


    public static List<Subject> initSubject(){
        List<String> lines = common.readFile("subjects.txt");
        List<Subject> subjectList = new ArrayList<>();

        for(String line:lines){
            String[] values = line.split(",");

            Subject subject = new Subject(Integer.parseInt(values[0]), values[1], Integer.parseInt(values[2]), Integer.parseInt(values[3]));
            subjectList.add(subject);
        }
        return subjectList;
    }

    public static List<Student_Subject> setStudentAndSubject(){
        Student_Subject relation1 = new Student_Subject(1,2);
        Student_Subject relation2 = new Student_Subject(2,3);
        Student_Subject relation3 = new Student_Subject(3,4);
        Student_Subject relation4 = new Student_Subject(4,1);
        Student_Subject relation5 = new Student_Subject(5,2);
        Student_Subject relation6 = new Student_Subject(6,3);
        Student_Subject relation7 = new Student_Subject(1,1);
        Student_Subject relation8 = new Student_Subject(2,4);

        List<Student_Subject> objList = new ArrayList<>();
        objList.add(relation1);
        objList.add(relation2);
        objList.add(relation3);
        objList.add(relation4);
        objList.add(relation5);
        objList.add(relation6);
        objList.add(relation7);
        objList.add(relation8);
        return objList;
    }

    public static List<FullTimeTeacher> getFullTimeTeachers(){
        FullTimeTeacher teacher1 = new FullTimeTeacher("Pepa","Garzon",55111222,01,1000,"Full Time",5);
        FullTimeTeacher teacher2 = new FullTimeTeacher("Lucho","Perez",66222333,02,2000,"Full Time",6);

        List<FullTimeTeacher> fullTimeTeacherList = new ArrayList<>();
        fullTimeTeacherList.add(teacher1);
        fullTimeTeacherList.add(teacher2);
        return fullTimeTeacherList;
    }

    public static List<PartTmeTeacher> getPartTimeTeachers(){
        PartTmeTeacher teacher1 = new PartTmeTeacher("Lucia","Sanchez",77333444,03,1000,"Part Time",30);
        PartTmeTeacher teacher2 = new PartTmeTeacher("Carlos","Castro",884445554,04,2000,"Part Time",40);

        List<PartTmeTeacher> partTimeTeacherList = new ArrayList<>();
        partTimeTeacherList.add(teacher1);
        partTimeTeacherList.add(teacher2);
        return partTimeTeacherList;
    }

}
