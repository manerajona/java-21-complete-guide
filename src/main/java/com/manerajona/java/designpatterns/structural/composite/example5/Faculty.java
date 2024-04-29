package com.manerajona.java.designpatterns.structural.composite.example5;

interface Faculty {
    String getDetails();
}

class Professor implements Faculty {
    private final String mName;
    private final String mPosition;
    private final int mOfficeNum;

    Professor(String name, String position, int officeNum) {
        mName = name;
        mPosition = position;
        mOfficeNum = officeNum;
    }

    @Override
    public String getDetails() {
        return "Professor{" +
                "mName='" + mName + '\'' +
                ", mPosition='" + mPosition + '\'' +
                ", mOfficeNum=" + mOfficeNum +
                '}';
    }
}