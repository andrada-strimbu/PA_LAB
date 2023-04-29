package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import java.sql.*;

public class Database {

    private static final String URL = "jdbc:postgresql://localhost:5432/lab8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    private static DataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10); // set the maximum number of connections to be created in the pool
        dataSource = new HikariDataSource(config);
    }

    private Database(){}

    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    public static void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }

    public static void closeStatement(Statement statement) throws SQLException{
        statement.close();
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException{
        preparedStatement.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException{
        resultSet.close();
    }
}
