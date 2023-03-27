package com.cb.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private Integer userId;

    private String userName;

    private String userRole;
}
