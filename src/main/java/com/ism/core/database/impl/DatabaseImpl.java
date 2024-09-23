package com.ism.core.database.impl;

import java.sql.*;

import com.ism.core.database.Database;

public class DatabaseImpl implements Database {

    private String url = "jdbc:mysql://localhost:8889/gestion_dette_glrs_2024";
    private String username = "root";
    private String password = "root";
    private Connection connection;

    protected PreparedStatement statement;

    public DatabaseImpl() {
        try {
            this.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Override
    public ResultSet executeQuery(String query, Object... params) throws SQLException {
        statement = connection.prepareStatement(query);
        setParameters(statement, params);
        return statement.executeQuery();
    }

    @Override
    public int executeUpdate(String query, Object... params) throws SQLException {
        if (query.toUpperCase().startsWith("INSERT")) {
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        } else {
            statement = connection.prepareStatement(query);
        }
        statement = connection.prepareStatement(query);
        setParameters(statement, params);
       return statement.executeUpdate();
    }

    private void setParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }
}
