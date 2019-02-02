package com.xiaoming.springbootlearning.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true, length = 50)
    private String nickName;
    private String password;
    @Column(nullable = false, unique = true)
    private String email;

    public MyUser() {
    }

    public MyUser(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public MyUser(Long id, String nickName, String password, String email) {
        this.id = id;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    @NonNull
    @Override
    public String toString() {
        return nickName;
    }
}
