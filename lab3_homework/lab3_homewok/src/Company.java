


import java.util.ArrayList;

public class Company implements Node, Comparable<Company> {
    private int id;
    private String name;
    private ArrayList<Person> employees;

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int getId(){
        return id;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Company " + name;
    }
}
