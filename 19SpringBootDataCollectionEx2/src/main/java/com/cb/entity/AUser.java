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
@Table(name = "usertab")
public class AUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer userId;

    @Column(name = "name")
    private String userName;

    @ElementCollection
    @CollectionTable(
                    name = "user_Roles",
                    joinColumns = @JoinColumn(name = "idFk")
    )
    @OrderColumn(name = "pos")
    @Column(name = "role")
    private List<String> roles;
}
