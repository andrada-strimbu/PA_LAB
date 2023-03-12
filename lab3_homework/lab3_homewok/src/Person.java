
import java.util.HashMap;
import java.util.Map;

public class Person implements Node,Comparable<Person>{

    private int id;
    private String birthDate;
    private String name;
    private Map<Node, String> relationships = new HashMap<>();
    public Person(int id, String birthDate, String name) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Person " + name;
    }
    public void addRelationship(Node node, String value) {
        if(this == node) {
            throw new RuntimeException("Can't add same node");
        }
        relationships.put(node, value);

    }
    public Map<Node, String> getRelationships() {
        return relationships;
    }
}

