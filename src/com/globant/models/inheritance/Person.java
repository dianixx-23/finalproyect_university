package com.globant.models.inheritance;

public class Person {
    private String name;
    private String lastName;
    private int numberId;


    public Person(String name, String latName, int numberId) {
        this.name = name;
        this.lastName = latName;
        this.numberId = numberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLatName(String latName) {
        this.lastName = latName;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

}
