package com.cb;

import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Setter
@ToString
@ConfigurationProperties("my.app")
public class DatabaseCon {

    private String driver;
    private String url;
    private String user;
    private String pwd;
}
