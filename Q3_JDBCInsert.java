// Q3_JDBCInsert.java
// Simple JDBC program to insert one hard-coded record into `studen

import java.sql.*;

public class Q3_JDBCInsert {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/prashant";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "prashsql3";

    public static void main(String[] args) {
        
        String createTableSql = "CREATE TABLE IF NOT EXISTS students ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(100) NOT NULL, "
                + "roll_no INT NOT NULL, "
                + "semester INT NOT NULL"
                + ")";

        String insertSql = "INSERT INTO students (name, roll_no, semester) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connection Successful");
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSql);
                System.out.println("Ensured 'students' table exists.");
            }

            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {

                ps.setString(1, "Prashant Srivastava");
                ps.setInt(2, 201);
                ps.setInt(3, 3);
                int rows = ps.executeUpdate();
                System.out.println("Inserted " + rows + " record(s) into students table. \"Record Inserted\"");
            }
        } catch (SQLException e) {
            System.err.println("DB Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

