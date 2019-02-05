package com.xiaoming.springbootlearning.domain;

import javax.persistence.*;

@Entity
public class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    private boolean active;

    public BaseUser() {
    }

    public BaseUser(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public BaseUser(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /*@NonNull
    @Override
    public String toString() {
        return username;
    }*/

    @Override
    public String toString() {
        return "BaseUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
