package com.globant.controller;

import com.globant.models.data.University;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        University uni = new University();
        Print(uni);
    }

    public static void Print(University uni){
        Menu(uni);
        Scanner sc = new Scanner (System.in);
        int option = sc.nextInt();
        uni.addTeachers();

        while(option > 0 && option < 6) {
            switch (option) {
                case 1:
                    uni.listTeachers();
                    break;
                case 2:
                    uni.listSubjects();
                    break;
                case 3:
                    uni.addStudent();
                    break;
                case 4:
                    uni.addSubject();
                    break;
                case 5:
                    uni.listStudentSubjects();
                    break;
            }
            Menu(uni);
            option = sc.nextInt();
        }
        if (option == 6){
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("See you soon. Thank you");
            System.out.println("------------------------------------------------------------------------------------------");
        }
        if (option <1 || option >=7){
            System.out.println("Incorrect option, Please insert the option again");
            Print(uni);
        }
    }

    public static void Menu(University uni){
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("¡Welcome to " + uni.getName() + "!");
        System.out.println("Enter the option to proceed:" + "\n1. List Teachers" + "\n2. List Subjects" + "\n3. Create New Student" + "\n4. Create New Subject" +
                "\n5. List Student's Subjects" + "\n6. Exit");
        System.out.println("------------------------------------------------------------------------------------------");
    }

    public static boolean isString(String text){
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

}
