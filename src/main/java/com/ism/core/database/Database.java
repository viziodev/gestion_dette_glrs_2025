package com.ism.core.database;

import java.sql.*;

public interface Database {
    void getConnection() throws SQLException;
    void closeConnection(Connection connection) throws SQLException;
    ResultSet executeQuery(String query, Object... params) throws SQLException;
    int executeUpdate(String query, Object... params) throws SQLException;
}
