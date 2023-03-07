import java.util.ArrayList;


public class Company implements Node, Comparable<Company> {

    private String name;
    private ArrayList<Company> employees;

    public ArrayList<Company> getEmployees() {
        return employees;
    }
@Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public  int compareTo(Company o){

        return this.name.compareTo(o.name);
    }

    @Override
     public String toString(){
        return "Company " + name;
    }
}
