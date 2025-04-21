package com.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test {

    static {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "doesntmatter";
        String password = "doesntmatter";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement("SELECT NOW()");
             ResultSet rs = stmt.executeQuery()) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Test() {
        // Just to trigger the static block
    }
}
