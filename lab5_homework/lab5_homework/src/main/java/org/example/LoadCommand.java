package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class LoadCommand implements Command {
  private String path;

    public LoadCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute() throws InvalidCatalogException, Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
    }

}
