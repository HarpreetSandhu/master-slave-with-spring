package com.therootcoder.sample.masterslavespring.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Harpreet Sandhu
 * @since 24-Mar-2019
 **/
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 6173412674537304420L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}