package com.cb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_tab")
public class User {

    @Id
    @Column(name = "id")
    private Integer uid;

    @Column(name = "name")
    private String uname;

    @ManyToMany
    @JoinTable(name = "user_roles_tab", joinColumns = @JoinColumn(name = "uIdFK"),
                    inverseJoinColumns = @JoinColumn(name = "rIdFK"))
    private List<Role> roles;
}
