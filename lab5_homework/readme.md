
-Am transformat metodele load, list, view si report in clasele LoadCommand, ListCommand, ViewCommand si ReportCommand care implementeaza interfata Command care are metoda execute;
-In clasa ReportCommand am folosit FreeMarker pentru a genera un HTML report, iar in HtmlReport.ftl avem template-ul pentru pagina noastra;
-Avem clasa InvalidCatalogException.java care functioneaza ca un custom exceptions;
-Am generat JAR archive 
