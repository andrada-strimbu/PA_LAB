package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs = new ArrayList<>();

    // constructors
    public Catalog() { }
    public Catalog(String name) { this.name = name; }

    // getters
    public String getName() { return name; }
    public List<Document> getDocs() { return docs; }

    // setters
    public void setName(String name) { this.name = name; }
    public void setDocs(List<Document> docs) { this.docs = docs; }

    // adder
    public void add(Document doc) { docs.add(doc); }

    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst().orElse(null);
    }
}