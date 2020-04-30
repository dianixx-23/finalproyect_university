package com.globant.models.data;

import com.globant.models.typeteacher.FullTimeTeacher;
import com.globant.models.typeteacher.PartTmeTeacher;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.globant.controller.Main.isString;
import static com.globant.util.Ini.*;


public class University {
    private String name = "Globant University";
    private List<Student> studentList;
    private List<Subject> subjectList;
    private List<FullTimeTeacher> ftTeacherlist;
    private List<PartTmeTeacher> ptTeacherList;
    private List<Student_Subject> objList;
    private List<Integer> teacherList = new ArrayList<>();
    private List<Student> newStudentList = new ArrayList<>();
    private List<Subject> newSubjectList = new ArrayList<>();
    private boolean foundStudent = false;
    private boolean foundSubject = false;
    private boolean valid = true;
    Scanner sc = new Scanner(System.in);


    public University() {
        this.studentList = initStudent();
        this.subjectList = initSubject();
        this.objList = setStudentAndSubject();
        this.ftTeacherlist = getFullTimeTeachers();
        this.ptTeacherList = getPartTimeTeachers();
    }

    
    public String getName() {
        return name;
    }


    public void listTeachers(){
        if(ftTeacherlist.size() == 0 || ptTeacherList.size() ==0){
            System.out.println("***************************************************************************************");
            System.out.println("*There are no Teachers* ");
            System.out.println("***************************************************************************************");
        }else{
            System.out.println("> Full Time Teachers: ");
            for (int i = 0; i< ftTeacherlist.size(); i++){
                ftTeacherlist.get(i).calculateSalary();
                System.out.println(ftTeacherlist.get(i) + "\n");
            }
            System.out.println("***************************************************************************************");
            System.out.println("> Part Time Teachers: ");
            for (int i = 0; i< ptTeacherList.size(); i++){
                ptTeacherList.get(i).calculateSalary();
                System.out.println(ptTeacherList.get(i) + "\n");
            }
            System.out.println("***************************************************************************************");
            }
    }



    public void listSubjects() {
        boolean subjectFound = false;
        int getStudentNumber, getStudentNumber2, getSubjectNumber,subjectOption=0, option =0;
        if (subjectList.size() == 0) {
            System.out.println("***************************************************************************************");
            System.out.println("*There are no Subjects* ");
            System.out.println("***************************************************************************************");
        } else {
            System.out.println("***************************************************************************************");
            System.out.println("Subjects: ");
            for (int l = 0; l < subjectList.size(); l++) {
                System.out.println(subjectList.get(l).toString());
            }

            //validate if ID is not numeric
            do{
                try{
                    System.out.println("***************************************************************************************");
                    System.out.println("Enter the Subject # to list the Students:");
                    subjectOption = sc.nextInt();
                    valid = true;
                }catch (InputMismatchException ime){
                    System.out.println("¡Careful! You can only insert numbers. ");
                    sc.next();
                    valid = false;
                }
            }while(valid == false);

            getTeacher(subjectOption);

            for (int i = 0; i < objList.size(); i++) {
                getSubjectNumber = objList.get(i).getSubjectNumber();
                if (getSubjectNumber == subjectOption) {
                    getStudentNumber = objList.get(i).getStudentNumber();
                    for (int j = 0; j < studentList.size(); j++) {
                        getStudentNumber2 = studentList.get(j).getStudentNumber();
                        if (getStudentNumber == getStudentNumber2) {
                            System.out.println("Student Associated: " + studentList.get(j));
                            subjectFound = true;
                        }
                    }
                }
            }
            if (subjectFound == false) {
                System.out.println("***************************************************************************************");
                System.out.println("Subject Not Found");
            }
        }
    }


    public void addStudent() {
        String studentName;
        String studentLastName;
        int getSubjectNumber, studentID = 0, studentAge=0, studentSubject1=0, option=0;
        boolean subjectFound = false;
        boolean valid = true;

        System.out.println("***************************************************************************************");
        System.out.println("Create New Student:");
        System.out.println("Enter Student Name:");
        studentName = sc.next();
        //validate if name is numeric
        do {
            if(isString(studentName)){
                System.out.println("¡Careful! You cannot insert numbers.");
                System.out.println("Enter Student Name:");
                studentName = sc.next();
            }
        }while(isString(studentName) == true);

        System.out.println("Enter Student Last Name:");
        studentLastName = sc.next();
        //validate if name is numeric
        do {
            if(isString(studentLastName)){
                System.out.println("¡Careful! You cannot insert numbers.");
                System.out.println("Enter Student Last Name:");
                studentLastName = sc.next();
            }
        }while(isString(studentLastName) == true);

        //validate if ID is not numeric
        do{
            try{
                System.out.println("Enter Student ID:");
                studentID = sc.nextInt();
                valid = true;
            }catch (InputMismatchException ime){
                System.out.println("¡Careful! You can only insert numbers. ");
                sc.next();
                valid = false;
            }
        }while(valid == false);

        //validate if age is not numeric
        do{
            try{
                System.out.println("Enter Student Age:");
                studentAge = sc.nextInt();
                valid = true;
            }catch (InputMismatchException ime){
                System.out.println("¡Careful! You can only insert numbers. ");
                sc.next();
                valid = false;
            }
        }while(valid == false);

        int countSubjectSelected = 0;
        int sizeSubjectList = subjectList.size();
        while (countSubjectSelected <= sizeSubjectList) {
            System.out.println("***************************************************************************************");
            System.out.println("Current subjects:");
            subjectList.forEach(subject -> System.out.println(subject.toString()));

            //validate if # is not numeric
            do {
                try {
                    System.out.println("***************************************************************************************");
                    System.out.println("Enter Subject # to associate with Student:");
                    studentSubject1 = sc.nextInt();
                    valid = true;
                } catch (InputMismatchException ime) {
                    System.out.println("¡Careful! You can only insert numbers. ");
                    sc.next();
                    valid = false;
                }
            } while (valid == false);


            // validate if subject was associated
            validateSubject(studentSubject1);
            if (foundSubject == false) {
                for (int i = 0; i < subjectList.size(); i++) {
                    getSubjectNumber = subjectList.get(i).getSubjectNumber();
                    if (getSubjectNumber == studentSubject1) {
                        subjectList.get(i).setSubjectNumber(studentSubject1);
                        newSubjectList.add(subjectList.get(i));
                        System.out.println("Subject Associated ");
                        newSubjectList.forEach(subject -> System.out.println(subject.toString()));
                        subjectFound = true;
                    }
                }
            } else{
                System.out.println("SUBJECT ALREADY ASSOCIATED!");
                foundSubject = false;
            }

            //validate if option is not numeric
            do{
                try{
                    System.out.println("***************************************************************************************");
                    System.out.println("Associate another Subject?, Enter: 1.Yes, 2.No:");
                    option = sc.nextInt();
                    valid = true;
                }catch (InputMismatchException ime){
                    System.out.println("¡Careful! You can only insert numbers. ");
                    sc.next();
                    valid = false;
                }
            }while(valid == false);

            if (option == 1) {
                countSubjectSelected = countSubjectSelected + 1;
            } else if (option == 2) {
                countSubjectSelected = countSubjectSelected + sizeSubjectList + 1;
            }
        }
        int sizeList = studentList.size();
        sizeList = sizeList + 1;
        Student student = new Student(studentName, studentLastName, studentID, sizeList, studentAge);
        student.setSubjectListStudent(newSubjectList);
        studentList.add(student);
        System.out.println("***************************************************************************************");
        System.out.println("STUDENT ADDED: ");
        System.out.println(student.toString());
        System.out.println("***************************************************************************************");
        System.out.println("SUBJECTS ASSOCIATED: ");
        newSubjectList.forEach(subject -> System.out.println(subject.toString()));
        for (int k = 0; k < newSubjectList.size(); k++) {//add to class student_Subject
            getSubjectNumber = newSubjectList.get(k).getSubjectNumber();
            Student_Subject element = new Student_Subject(sizeList, getSubjectNumber);
            objList.add(element);
        }
    }



    public void addSubject(){
        String subjectName;
        int classroomNum, teacherNum, getStudentNumber;
        boolean valid = true;

        System.out.println("***************************************************************************************");
        System.out.println("Create Subject:");
        System.out.println("Enter Subject Name:");
        subjectName = sc.next();
        //validate if name is numeric
        do {
            if(isString(subjectName)){
                System.out.println("¡Careful! You cannot insert numbers.");
                System.out.println("Enter Subject Name:");
                subjectName = sc.next();
            }
        }while(isString(subjectName) == true);


        //validate if classroom number is not numeric
        do{
            try{
                System.out.println("Enter Classroom Number:");
                classroomNum = sc.nextInt();
                valid = true;
            }catch (InputMismatchException ime){
                System.out.println("¡Careful! You can only insert numbers. ");
                sc.next();
                valid = false;
            }
        }while(valid == false);

        //assign a teacher
        System.out.println("***************************************************************************************");
        System.out.println("Current Teachers:");
        ftTeacherlist.forEach(teacher -> System.out.println(" Teacher #: "+ teacher.getTeacherNumber() + ", Name: " + teacher.getName() + ", Last Name: " + teacher.getLastName() + ", type: " +teacher.getTypeTeacher()));
        ptTeacherList.forEach(teacher -> System.out.println(" Teacher #: "+ teacher.getTeacherNumber() + ", Name: " + teacher.getName() + ", Last Name: " + teacher.getLastName() + ", type: " +teacher.getTypeTeacher()));

        //validate if option is not numeric
        teacherNum = 0;
        do{
            try{
                System.out.println("***************************************************************************************");
                System.out.println("Enter # of teacher to associate with subject:");
                teacherNum = sc.nextInt();
                valid = true;
            }catch (InputMismatchException ime){
                System.out.println("¡Careful! You can only insert numbers. ");
                sc.next();
                valid = false;
            }
        }while(valid == false);


        if(teacherNum > teacherList.size()){
            System.out.println("Incorrect option");
        }else{
            //Show teacher assigned
            getTeacher(teacherNum);
            //Associate students
            int countSubjectSelected = 0;
            int sizeSubjectList = studentList.size();

            while (countSubjectSelected <= sizeSubjectList) {
                System.out.println("***************************************************************************************");
                System.out.println("Current students: ");
                studentList.forEach(student -> System.out.println(student.toString()));

                //validate if studentSubject1 is not numeric
                int studentSubject1 = 0;
                do{
                    try{
                        System.out.println("***************************************************************************************");
                        System.out.println("Enter student # to associate with subject:");
                        studentSubject1 = sc.nextInt();
                        valid = true;
                    }catch (InputMismatchException ime){
                        System.out.println("¡Careful! You can only insert numbers. ");
                        sc.next();
                        valid = false;
                    }
                }while(valid == false);


                //validate if student was already added.
                validateStudent(studentSubject1);
                if (foundStudent == false){
                    for (int i = 0; i < studentList.size(); i++) {
                        getStudentNumber = studentList.get(i).getStudentNumber();
                        if (getStudentNumber == studentSubject1) {
                            studentList.get(i).setStudentNumber(studentSubject1);
                            newStudentList.add(studentList.get(i));
                            System.out.println("Students Associated: ");
                            newStudentList.forEach(student -> System.out.println(student.toString()));
                        }
                    }
                } else{
                    System.out.println("STUDENT ALREADY ASSOCIATED!");
                    foundStudent = false;
                }

                //validate if option is not numeric
                int option = 0;
                do{
                    try{
                        System.out.println("***************************************************************************************");
                        System.out.println("Associate another Student?, Enter: 1.Yes, 2.No:");
                        option = sc.nextInt();
                        valid = true;
                    }catch (InputMismatchException ime){
                        System.out.println("¡Careful! You can only insert numbers. ");
                        sc.next();
                        valid = false;
                    }
                }while(valid == false);


                if (option == 1) {
                    countSubjectSelected = countSubjectSelected + 1;
                } else if(option == 2){
                    countSubjectSelected = countSubjectSelected + sizeSubjectList +1;
                }
            }
            int sizeList = subjectList.size();
            sizeList = sizeList +1;
            Subject subject = new Subject(sizeList,subjectName,classroomNum = 0,teacherNum);
            subject.setStudentList(newStudentList);
            subjectList.add(subject);
            System.out.println("***************************************************************************************");
            System.out.println("SUBJECT ADDED: ");
            System.out.println(subject.toString());
            //Show teacher assigned
            getTeacher(teacherNum);
            System.out.println("***************************************************************************************");
            System.out.println("STUDENTS ASSOCIATED: ");
            newStudentList.forEach(student -> System.out.println(student.toString()));
            for(int k=0; k<newStudentList.size(); k++){//add to class student_Subject
                getStudentNumber = newStudentList.get(k).getStudentNumber();
                Student_Subject element = new Student_Subject(getStudentNumber, sizeList);
                objList.add(element);
            }
        }
    }



    public void listStudentSubjects(){
        int optionStudent=0, getStudentNumber,getStudentNumber1, getSubjectNumber, getSubjectNumber1;
        boolean studentFound = false;
        System.out.println("***************************************************************************************");
        System.out.println("Current Students:");
        studentList.forEach(student -> System.out.println(student.toString()));


        //validate if option is not numeric
        do{
            try{
                System.out.println("***************************************************************************************");
                System.out.println("Enter student # to list its subjects:");
                optionStudent = sc.nextInt();
                valid = true;
            }catch (InputMismatchException ime){
                System.out.println("¡Careful! You can only insert numbers. ");
                sc.next();
                valid = false;
            }
        }while(valid == false);


        for(int i=0; i<studentList.size();i++){
            getStudentNumber = studentList.get(i).getStudentNumber();
            if (optionStudent == getStudentNumber){
                studentFound = true;
                System.out.println("***************************************************************************************");
                System.out.println("Subjects: ");
                for(int j=0; j<objList.size();j++){
                    getStudentNumber1 = objList.get(j).getStudentNumber();
                    if(getStudentNumber1 == getStudentNumber){
                        getSubjectNumber = objList.get(j).getSubjectNumber();
                        printSubject(getSubjectNumber);
                    }
                }
            }
        }
        if(studentFound == false){
            System.out.println("***************************************************************************************");
            System.out.println("Student not found");
            System.out.println("***************************************************************************************");
        }

    }


    public void printSubject(int subjectNumber){
        int getSubjectNumber1;
        for (int k=0; k<subjectList.size(); k++){
            getSubjectNumber1 = subjectList.get(k).getSubjectNumber();
            if(subjectNumber == getSubjectNumber1){
                System.out.println(subjectList.get(k).toString());
            }
        }

    }

    public void addTeachers(){
        for (int i = 0; i< ftTeacherlist.size(); i++) {
            teacherList.add(i);
        }
        for (int j=0; j< ptTeacherList.size(); j++) {
            teacherList.add(j);
        }
    }



    public void getTeacher(int teacherNumber){
        int getTeacherFTNumber, getTeacherPTNumber;
        for (int i = 0; i< ftTeacherlist.size(); i++) {
            getTeacherFTNumber = ftTeacherlist.get(i).getTeacherNumber();
            for (int j=0; j< ptTeacherList.size(); j++){
                getTeacherPTNumber = ptTeacherList.get(j).getTeacherNumber();
                if (getTeacherFTNumber == teacherNumber){
                    System.out.println("***************************************************************************************");
                    System.out.println("Teacher Assigned: " + ftTeacherlist.get(i).getName() + " " + ftTeacherlist.get(i).getLastName());
                    System.out.println("***************************************************************************************");
                    break;
                }else if (getTeacherPTNumber == teacherNumber){
                    System.out.println("***************************************************************************************");
                    System.out.println("Teacher Assigned: " + ptTeacherList.get(j).getName() + " " + ptTeacherList.get(j).getLastName());
                    System.out.println("***************************************************************************************");
                    break;
                }
            }
            break;
        }
    }


    public boolean validateStudent(int studentNum){
        for (int i=0; i<newStudentList.size(); i++){
            if (newStudentList.get(i).getStudentNumber() == studentNum){
                foundStudent = true;
            }
        }
        return foundStudent;
    }


    public boolean validateSubject(int subjectNum){
        for (int i=0; i<newSubjectList.size(); i++){
            if (newSubjectList.get(i).getSubjectNumber() == subjectNum){
                foundSubject = true;
            }
        }
        return foundSubject;
    }
}

