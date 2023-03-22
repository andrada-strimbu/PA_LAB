package org.example;


import java.io.IOException;
import java.io.Serializable;

public class Main {
    private final String path = "./catalog.json";

    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("1", "article1", path);
        var article = new Document("2", "book1", path);
        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, path);
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load(path);
        CatalogUtil.view(catalog.findById("article1"));
    }
}