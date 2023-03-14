package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<Project> listOfProjects = new ArrayList<>();
    public Student(String name) {
        this.name = name;
    }
    public void addProject(Project p){
        listOfProjects.add(p);

    }
    public String getName() {
        return name;
    }
    @Override
    public int compareTo(Student o) {

        return this.name.compareTo((o.name));
    }

    @Override
    public String toString() {
        return name;
    }
}
