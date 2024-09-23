package com.ism.core.database;

import java.sql.*;

public interface Database {
    void getConnection() throws SQLException;
    void closeConnection() throws SQLException;

    ResultSet executeQuery() throws SQLException;

    void initPreparedStatement(String sql) throws SQLException;

    int executeUpdate() throws SQLException;
}
