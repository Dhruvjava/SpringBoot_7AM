package com.cb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "role_tab")
public class Role {

    @Id
    @Column(name = "id")
    private  Integer rid;

    @Column(name = "name")
    private String name;
}
