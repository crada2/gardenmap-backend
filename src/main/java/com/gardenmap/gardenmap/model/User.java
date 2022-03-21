package com.gardenmap.gardenmap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String direction;
    private Long telephone;

    @JsonIgnore
    private String password;
    public User(String name) {
        this.username = name;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Product> product = new HashSet<>();

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;

        for(Product n : product) {
            n.setUser(this);
        }
    }

    public User(String username, String email, String encode, String direction, Long telephone) {
        this.username = username;
        this.email = email;
        this.password = encode;
        this.direction = direction;
        this.telephone = telephone;
    }

}
