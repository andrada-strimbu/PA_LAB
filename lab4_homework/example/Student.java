package org.example;
import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private List<Project> admissibleProjects = new ArrayList<>();

    public Student(String name ) {
        this.name = name;
    }
    public void addProject (Project p){
        admissibleProjects.add(p);
    }

    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    @Override
    public int compareTo(Student o) {
        return this.admissibleProjects.size() - o.admissibleProjects.size();
    }

    @Override
    public String toString() {
        return name;
    }
}

