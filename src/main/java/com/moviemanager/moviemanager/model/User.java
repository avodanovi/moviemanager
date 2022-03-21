package com.moviemanager.moviemanager.model;


import javax.persistence.*;


@Entity
@Table(name="user")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    @Column(nullable = false,unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private boolean enabled;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;

    public User() {
    }

    public User(String password) {
        this.password = password;
    }

    public User(String user_name, Integer role_id, String password, Role role){
        this.username=user_name;
        this.password = password;
        this.role=role;
    }

    public Integer getUser_Id() {
        return user_id;
    }

    public String getUser_name() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public void  setUser_id(Integer id){
        this.user_id=id;
    }
    public void setUser_name(String name){
        this.username=name;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getPassword() {


        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
