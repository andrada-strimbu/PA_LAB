package org.example;


import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String path = "./catalog.json";

    public static void main(String[] args) throws Exception {
        ReportCommand reportGenerator = new ReportCommand();
        List<Document> documents = new ArrayList<>();

        // Add some products to the list
        documents.add(new Document("Product 1", "Description 1", path));
        documents.add(new Document("Product 2", "Description 2", path));
        documents.add(new Document("Product 3", "Description 3", path));

        try {
            reportGenerator.execute();
        } catch (IOException | TemplateException | InvalidCatalogException e) {
            e.printStackTrace();
        }
    }


}