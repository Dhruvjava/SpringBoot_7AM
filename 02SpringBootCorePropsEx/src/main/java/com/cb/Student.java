package com.cb;

public class Student {

    private String name;

    private String add;

    private String sal;

    public void setName(String name) {
        this.name = name;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", add='" + add + '\'' +
                ", sal='" + sal + '\'' +
                '}';
    }
}
