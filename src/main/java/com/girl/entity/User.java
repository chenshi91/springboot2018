package com.girl.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
    private Integer id;

    private String  name;

    @JsonIgnore
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd H:m:s",locale = "zh",timezone = "GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd H:m:s")
    private Date    birthday;

    private String  address;

    public User() {
    }

    public User(String name, Integer age, Date birthday, String address) {

        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
