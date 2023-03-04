package com.cb;

import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Setter
@ToString
@ConfigurationProperties("my.users")
public class UserReg {
    private String firstName;
    private String lastName;
    private String user;
    private String pwd;
}
