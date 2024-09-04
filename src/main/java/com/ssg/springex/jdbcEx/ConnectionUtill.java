package com.ssg.springex.jdbcEx;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtill {

    INSTANCE;

    private HikariDataSource ds;

    ConnectionUtill() {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC");
        config.setUsername("root");
        config.setPassword("0000");

        config.addDataSourceProperty("cachePrepStmt","true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtChacheSqlLimit", "2048");

        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws Exception{
        return ds.getConnection();
    }
}
