package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.awt.*;
import java.io.File;

public class CatalogUtil {
    public CatalogUtil() { }

    public static void save(Catalog catalog, String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        return catalog;
    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        // .. browse or open, depending on the location type
    }
}