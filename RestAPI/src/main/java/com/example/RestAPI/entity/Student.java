package com.example.secondtask.entity;

import javax.persistence.*;

//the base entity that will be the database object
@Entity
@Table (name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "team")
    private String team;

    public Student(Integer id, String firstname, String lastname, String middlename, String birthday, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.birthday = birthday;
        this.team = team;
    }

    public Student() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
