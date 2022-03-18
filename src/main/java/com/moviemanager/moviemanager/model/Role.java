package com.moviemanager.moviemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer role_id;
    @Column(nullable = false,unique = true,length = 50)
    private String role_name;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();


    public Role(){}

    public Role(Integer role_id){
        this.role_id=role_id;
    }

    public Role(String role_name){
        this.role_name=role_name;    }

    public Role(Integer role_id,String role_name){
        this.role_name=role_name;
        this.role_id=role_id;
    }
    public Set<User> getUsers() {
        return users;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
