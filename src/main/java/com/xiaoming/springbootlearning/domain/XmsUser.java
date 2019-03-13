package com.xiaoming.springbootlearning.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class XmsUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String nickname;

    @Column
    private Date lastPasswordReset;

    private boolean enable;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "uid", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "rid", referencedColumnName = "id")})
    private List<Role> roles;

    public XmsUser() {
    }

    public XmsUser(Long id, String password) {
        this.id = id;
        this.password = password;
    }

    public XmsUser(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /*@NonNull
    @Override
    public String toString() {
        return username;
    }*/

    @Override
    public String toString() {
        return "XmsUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
