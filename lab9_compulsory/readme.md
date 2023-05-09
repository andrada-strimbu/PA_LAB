COMPULSORY
----------
- Create a persistence unit (use EclipseLink or Hibernate or other JPA implementation).
Verify the presence of the persistence.xml file in your project. Make sure that the driver for EclipseLink or Hibernate was added to to your project classpath (or add it yourself).
- Define the entity classes for your model (at least one) and put them in a dedicated package. You may use the IDE support in order to generate entity classes from database tables.
- Create a singleton responsible with the management of an EntityManagerFactory object.
- Define repository clases for your entities (at least one). They must contain the following methods:
- - create - receives an entity and saves it into the database;
- - findById - returns an entity based on its primary key;
- - findByName - returns a list of entities that match a given name pattern. Use a named query in order to implement this method.
- Test your application.
----------------------------------------------------------------
- Am creat un persistence.xml in proiectul meu si am adaugat toate dependentele in pom.xml;
- Am definit pentru toate clasele mele entitatile;
- Am creat clasa EntityManagerFactory care ma juta sa ma conectez cu baza de date prin intermediul persistence.xml;
- Am creat clasa AlbumsRepository care defineste metodele create, findbyId, findbyName;

HOMEWORK
---------
- Create all entity classes and repositories. Implement properly the one-to-many and many-to-many relationships.
- Create a generic AbstractRepository using generics in order to simplify the creation of the repository classes. You may take a look at the CrudRepository interface from Spring Framework.
- Insert, using JPA, a large number of fake artists and albums in the database and log the execution time of your JPQL statements.
--------------------------------------------------------------------------------------
- Am creat clasele repository pentru toate tabelele. Am adaugat si relatiile intre tabele
- Am creat interfata AbstractRepository  care ma ajuta sa generez CRUD-ul pentru orice tabela care o implementeaza.
