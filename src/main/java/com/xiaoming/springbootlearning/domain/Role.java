package com.xiaoming.springbootlearning.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author Xiaoming.
 * Created on 2019/03/12 23:18.
 * Description :
 */
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
