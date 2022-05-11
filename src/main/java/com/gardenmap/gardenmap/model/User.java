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
@Table(name = "user")
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

    @JsonIgnore
    private String password;
    public User(String name) {
        this.username = name;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Product> product = new HashSet<>();

    @ManyToMany
    private Set<Role> roles;

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;

        for(Product n : product) {
            n.setUser(this);
        }
    }

    public User(long id, String name) {
        this.username = name;
        this.id = id;
    }

    public User(String username, String email, String encode) {
        this.username = username;
        this.email = email;
        this.password = encode;
    }
}
