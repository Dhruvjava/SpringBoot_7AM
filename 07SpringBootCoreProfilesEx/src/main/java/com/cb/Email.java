package com.cb;

import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Setter
@ToString
@ConfigurationProperties("my.email")
public class Email {
    private String host;
    private String port;
    private String user;
    private String pwd;
}
