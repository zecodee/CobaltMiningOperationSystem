/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.DatabaseConfig;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author zefrialrizkullah
 */

final class JdbcSupport {
    private JdbcSupport() {}
    
    static Connection open() throws SQLException {
        return DatabaseConfig.getConnection();
    }
    
    static RuntimeException fail(String operation, SQLException e) {
        return new IllegalStateException("Database gagal saat " + operation + ": " + e.getMessage(), e);
    }
    
    static void generated(PreparedStatement ps, java.util.function.IntConsumer setter) throws SQLException {
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (!rs.next()) throw new SQLException("Database tidak mengembalikan ID baru.");
            setter.accept(rs.getInt(1));
        }
    }
    
    static void requireChanged(int count, String name) {
        if (count == 0) throw new exception.DataNotFoundException(name + " tidak ditemukan.");
    }
    
    static void date(PreparedStatement ps, int index, LocalDate date) throws SQLException {
        if (date == null) ps.setNull(index, Types.DATE);
        else ps.setDate(index, Date.valueOf(date));
    }
    
    static void datetime(PreparedStatement ps, int index, LocalDateTime date) throws SQLException {
        if (date == null) ps.setNull(index, Types.TIMESTAMP);
        else ps.setTimestamp(index, Timestamp.valueOf(date));
    }
    
    static LocalDate date(ResultSet rs, String column) throws SQLException {
        Date value = rs.getDate(column);
        return value == null ? null : value.toLocalDate();
    }
    
    static LocalDateTime datetime(ResultSet rs, String column) throws SQLException {
        Timestamp value = rs.getTimestamp(column);
        return value == null ? null : value.toLocalDateTime();
    }
    
    static <E extends Enum<E>> E enumValue(ResultSet rs, String column, Class<E> type) throws SQLException {
        String value = rs.getString(column);
        return value == null ? null : Enum.valueOf(type, value);
    }
    
    static void nullableDouble(PreparedStatement ps, int index, Double value) throws SQLException {
        if (value == null) ps.setNull(index, Types.DECIMAL);
        else ps.setBigDecimal(index, java.math.BigDecimal.valueOf(value));
    }
    
    static Double nullableDouble(ResultSet rs, String column) throws SQLException {
        java.math.BigDecimal value = rs.getBigDecimal(column);
        return value == null ? null : value.doubleValue();
    }
    
    static void rollback(Connection c, Exception original) {
        try {
            c.rollback();
        }
        catch (SQLException e) {
            original.addSuppressed(e);
        }
    }
}
