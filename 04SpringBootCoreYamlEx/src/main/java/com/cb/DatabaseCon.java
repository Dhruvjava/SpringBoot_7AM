package com.cb;

import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@Setter
@ToString
@ConfigurationProperties("my.app")
public class DatabaseCon {

//    @Value("${my.app.driver}")
    private String driver;
//    @Value("${my.app.url}")
    private String url;
//    @Value("${my.app.username}")
    private String username;
//    @Value("${my.app.password}")
    private String password;

    private Set<String> set;

    private Map<String, String> map;

}
