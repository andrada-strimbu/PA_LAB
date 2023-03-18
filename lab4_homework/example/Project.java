package org.example;


public class Project implements Comparable <Project> {
    private String name;
    public boolean taken = false;
    public Project(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Project o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

