package com.robin.fragments;

public class gpastorage {// string variable for
    // storing employee name.
    private String Name;

    // string variable for storing
    // employee contact number
    private String dept;

    // string variable for storing
    // employee address.
    private String sem;


    private String gpa;

    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public gpastorage() {

    }

    // created getter and setter methods
    // for all our variables.
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getdept() {
        return dept;
    }

    public void setdept(String dept) {
        this.dept = dept;
    }

    public String getsem() {
        return sem;
    }

    public void setsem(String sem) {
        this.sem = sem;
    }

    public String getgpa() {
        return gpa;
    }

    public void setgpa(String gpa) {
        this.gpa = gpa;
    }
}

