package com.girl.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;

import java.util.Date;


@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Boy {
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message="姓名毕传")
    private String name;
    @Max(value=30,message="耍帅不能超过30岁")
    private Integer age;
    private String  address;
    @DateTimeFormat(pattern = "yyyy-MM-d")
    @JsonFormat(pattern = "yyyy-MM-d")
    private Date birthday;

    public Boy() {
    }

    public Boy(String name, Integer age, String address, Date birthday) {

        this.name = name;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boy(Integer id, String name, Integer age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Boy [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (age != null ? "age=" + age + ", " : "") + (address != null ? "address=" + address + ", " : "")
				+ (birthday != null ? "birthday=" + birthday : "") + "]";
	}
}
