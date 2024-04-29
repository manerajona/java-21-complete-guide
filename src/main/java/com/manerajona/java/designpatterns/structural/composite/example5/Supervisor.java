package com.manerajona.java.designpatterns.structural.composite.example5;

import java.util.ArrayList;
import java.util.List;

class Supervisor implements Faculty {

    private final String name;
    private final String deptName;
    private final List<Faculty> myFacultyList;

    Supervisor(String name, String deptName) {
        this.name = name;
        this.deptName = deptName;
        myFacultyList = new ArrayList<>();
    }

    public void add(Faculty professor) {
        myFacultyList.add(professor);
    }

    public void remove(Faculty professor) {
        myFacultyList.remove(professor);
    }

    public List<Faculty> getMyFaculty() {
        return myFacultyList;
    }

    @Override
    public String getDetails() {
        return "Supervisor{" +
                "name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", myFacultyList=" + myFacultyList +
                '}';
    }
}
