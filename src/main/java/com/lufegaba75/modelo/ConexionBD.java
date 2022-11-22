package com.lufegaba75.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static String url = "jdbc:mysql://localhost:3306/MantenedorUsuarios?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        return connection = DriverManager.getConnection(url, username, password);
    }
}
