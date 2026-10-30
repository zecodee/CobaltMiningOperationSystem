/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author zefrialrizkullah
 */

public final class DatabaseConfig {
    private DatabaseConfig() {}
    
    private static String env(String key, String fallback) {
        String value = System.getenv(key);
        return value == null || value.trim().isEmpty() ? fallback : value;
    }
    
    public static Connection getConnection() throws SQLException {
        String url = env("CMOS_DB_URL", "jdbc:mysql://localhost:3308/cmos_db");
        String username = env("CMOS_DB_USER", "root");
        String password = System.getenv("CMOS_DB_PASSWORD");
        return DriverManager.getConnection(url, username, password == null ? "" : password);
    }
    
    public static boolean testConnection() {
        try (Connection connection = getConnection()) {
            return connection.isValid(5);
        } 
        
        catch (SQLException e) {
            System.err.println("Koneksi database gagal: " + e.getMessage());
            return false;
        }
    }
}
