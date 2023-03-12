
import java.util.*;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) {

        Designer a = new Designer(12, "123", "Andrada", "java");
        Programmer b = new Programmer(14, "123", "Carina", "python");
        a.addRelationship(b, "friend");
        Company c = new Company(15, "centric");
        List<Node> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        for (Node node : list) {
            System.out.println(node);
        }
        Network n = new Network();
        n.addNode(a);
        n.addNode(b);
        n.addNode(c);
        System.out.println(n);



    }



}
