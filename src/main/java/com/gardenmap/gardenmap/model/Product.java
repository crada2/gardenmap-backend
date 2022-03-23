package com.gardenmap.gardenmap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table (name="products")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direction;
    private Long telephone;
    private String title;
    private String observations;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

}
