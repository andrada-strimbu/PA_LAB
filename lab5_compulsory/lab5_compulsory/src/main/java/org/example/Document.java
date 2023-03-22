package org.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id, title, location;

    // constructors
    public Document() { }
    public Document(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    // getter
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public Map<String, Object> getTags() { return tags; }

    // setter

    public void setId(String id) { this.id = id; }
    public void setTitle(String title) {this.title = title; }
    public void setLocation(String location) { this.location = location; }
    public void setTags(Map<String, Object> tags) { this.tags = tags;  }

    // additional functions
    private Map<String, Object> tags = new HashMap<>();
    public void addTag(String key, Object obj) { tags.put(key, obj); }

    @Override public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }
}