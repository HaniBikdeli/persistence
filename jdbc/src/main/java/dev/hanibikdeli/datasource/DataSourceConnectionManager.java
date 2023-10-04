package dev.hanibikdeli.datasource;

import dev.hanibikdeli.log.AbstractLogger;

import java.sql.*;

public class DataSourceConnectionManager extends AbstractLogger {

    private static final String jdbc = "jdbc:postgresql://localhost:5432/presistence";

    private static final String username = "root";
    private static final String password = "root";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(jdbc, username, password);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void closeConnection(Connection connection, ResultSet resultSet, Statement statement, PreparedStatement preparedStatement) throws SQLException {
        if (statement != null)
            statement.close();
        if (preparedStatement != null)
            preparedStatement.close();
        if (resultSet != null)
            resultSet.close();
        if (connection != null)
            connection.close();
    }
}
