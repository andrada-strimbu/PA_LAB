package org.example;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ReportCommand implements Command{

      List<Document> documents;

    public ReportCommand() {
    }


    @Override
    public void execute() throws InvalidCatalogException, Exception,TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(getClass(), "C:\\Users\\abc\\IdeaProjects\\lab5_homework\\src\\main\\java\\org\\example\\HtmlReport.ftl");
        Template template = cfg.getTemplate("HtmlReport.ftl");

        Map<String, Object> data = new HashMap<>();
        data.put("documents", documents);

        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        template.process(data, writer);
        writer.flush();
    }
}
