import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Node> list = new ArrayList<Node>();
        Person a = new Person();
        a.setName("Andrada");
        Person b = new Person();
        Company c = new Company();
        b.setName("Cezara");
        c.setName("Amazon");
        list.add(a);
        list.add(b);
        list.add(c);
        for(Node  node : list ){
            System.out. println(node);
        }


    }

}