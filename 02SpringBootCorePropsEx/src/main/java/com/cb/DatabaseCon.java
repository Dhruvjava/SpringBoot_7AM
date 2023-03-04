package com.cb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "my.app")
public class DatabaseCon {

//    @Value("${my.app.driver}")
    private String driver;
//    @Value("${my.app.url}")
    private String url;
//    @Value("${my.app.username}")
    private String username;
//    @Value("${my.app.password}")
    private String password;

    List<String> data;

    Map<String,String> map;

    private Student st;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSt(Student st) {
        this.st = st;
    }

    @Override
    public String toString() {
        return "DatabaseCon{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", data=" + data +
                ", map=" + map +
                ", st=" + st +
                '}';
    }
}
