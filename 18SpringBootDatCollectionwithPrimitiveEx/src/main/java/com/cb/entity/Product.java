package com.cb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "producttab")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer prodId;

    @Column(name = "code")
    private String prodCode;

    @ElementCollection // mandatory for collection type
    @CollectionTable( // Optional for child table name and fk col name
                    name = "product_colors",
                    joinColumns = @JoinColumn(name = "idFk"))
    @OrderColumn(name = "pos") // index for List order
    @Column(name="data")
    private List<String> colors;

    @ElementCollection
    @CollectionTable(
                    name = "product_model",
                    joinColumns = @JoinColumn(name = "idFk")
    )
    @Column(name = "model")
    private Set<String> models;

    @ElementCollection
    @CollectionTable(
                    name = "product_details",
                    joinColumns = @JoinColumn(name = "idFk")
    )
    @MapKeyColumn(name = "code") // index for Map key
    @Column(name = "details")
    private Map<String, String> details;
}
