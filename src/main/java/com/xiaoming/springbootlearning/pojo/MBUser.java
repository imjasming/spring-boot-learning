package com.xiaoming.springbootlearning.pojo;

import java.io.Serializable;

/**
 * @author Xiaoming.
 * Created on 2019/03/06 23:22.
 * Description :
 */
public class MBUser implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public MBUser(){
        super();
    }

    public MBUser(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
