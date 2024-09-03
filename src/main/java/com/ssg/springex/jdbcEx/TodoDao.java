package com.ssg.springex.jdbcEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDao {

    String now = null;

    public String getTime() throws Exception {
        String now = null;
        try (Connection con = ConnectionUtill.INSTANCE.getConnection();
             PreparedStatement ps = con.prepareStatement("select now()");
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                now = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;  // Rethrow the exception if needed
        }
        return now;
    }

}
