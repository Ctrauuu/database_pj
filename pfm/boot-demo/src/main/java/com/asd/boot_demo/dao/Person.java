package com.asd.boot_demo.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 主键自动增长
    @Column(name = "person_id")  // 映射到数据库表的person_id字段
    private int personId;

    @Column(name = "name", nullable = false)  // 映射到数据库表的name字段，不能为空
    private String name;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)  // 枚举映射，使用字符串存储，避免存储数字
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    // Getters and Setters
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Gender 枚举类
    public enum Gender {
        Male,
        Female,
        Other
    }
}
