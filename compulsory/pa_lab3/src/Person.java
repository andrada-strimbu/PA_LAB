import java.util.ArrayList;

public class Person implements Node, Comparable<Person> {
    private String name;
    private ArrayList<Person> friends;
    private Company employer;

    public ArrayList<Person> getFriends() {
      return friends;
    }
 @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getEmployer() {
        return employer;
    }

    public void setEmployer(Company employer) {
        this.employer = employer;
    }

    @Override
    public  int compareTo(Person o){

       return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Person " + name;
    }
}
