package com.ssg.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
public class testHikariCP {
    @Test
    public void testHikari() throws Exception {
        //hikari config 객체를 생성해서 hikari datasource 생성
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC");
        config.setUsername("root");
        config.setPassword("0000");

        config.addDataSourceProperty("cachePrepStmt","true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtChacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
