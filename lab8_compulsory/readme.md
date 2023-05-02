------------------COMPULSORY-----------------

Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
Write an SQL script that will create the following tables:
albums: id, release year, title, artist, genre(s)
artists: id, name (for example: Beatles)
genres: id, name (for example: Rock)
an associative (junction) table in order to store each album genres
Update pom.xml, in order to add the database driver to the project libraries.
Create a singleton class in order to manage a connection to the database.
Create DAO classes that offer methods for managing artists, genres and albums (at least one).
Implement a simple test using your classes.

- Am creat o baza de date relationala in Postgres;
- Am creat tabele in java si in pgAdmin;
- Am pus dependentele in pom.xml pentru postgres;
- Am creat clasa Database care conecteaza clasele create in java cu baza de date din postgres;
- Am creat operatiile CRUD pentru tabela Albums;

------------------OPTIONAL-----------------
Create an object-oriented model of the data managed by the Java application.
Implement all the DAO classes.
Use a connection pool in order to manage database connections, such as C3PO, HikariCP or Apache Commons DBCP.
Create a tool to import data from a real dataset, such as Rolling Stone's 500 Greatest Albums of All Time (or other)

- Am creat pentru fiecare tabel operatiile CRUD;
- Am modificat Database si am utilizat HikariCP, am adaugat dependentele in pom.xml;
- Am creat clasa ImportDataTool care populeaza tabelele create in pgAdmin cu ajutorul datelor din "albumlist.csv"; 

------------------BONUS-----------------
Extend the model in order to create playlists. A playlist has a name, a creation timestamp and a set of albums.
Two albums are related if they meet at least one of the following conditions: are composed by the same artist or have been released in the same year or have at least one common genre.
Create an algorithm that generates maximal playlists (all of them or a limited number, if there are too many) that contain only unrelated albums.
Resources
- Am creat clasa Playlist
