package com.cb.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Database {

    @Value("${my.db.driver}")
    private String driver;
    @Value("${my.db.url}")
    private String url;
    @Value("${my.db.username}")
    private String username;
    @Value("${my.db.password}")
    private String password;

    @Override
    public String toString() {
        return "Database{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
