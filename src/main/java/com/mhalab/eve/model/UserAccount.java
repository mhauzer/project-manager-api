package com.mhalab.eve.model;

import javax.persistence.*;

// MHA: I had to name the class UserAccount because when it was User, Postgresql needed it to be used
//      in quotes but JDBC didn't use quotes so there was an error
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false, updatable=false)
    private Long id;

    @Column(nullable=false, unique=true)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private String role;

    @ManyToOne
    private Person person;

    public UserAccount() {
    }

    public UserAccount(String username, String password, String role, Person person) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
