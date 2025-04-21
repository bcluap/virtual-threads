package com.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

    static {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "someuser";
        String password = "somepassword";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT NOW()");
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                System.out.println("Current time from DB: " + rs.getString(1));
            }

        } catch (Exception e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Test() {
        // Just to trigger the static block
    }
}
