package org.example;

import java.awt.*;

public class ViewCommand implements Command{
    private Document doc;

    public ViewCommand(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute() throws InvalidCatalogException, Exception {
        Desktop desktop = Desktop.getDesktop();

    }
}
