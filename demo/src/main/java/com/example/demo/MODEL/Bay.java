package com.example.demo.MODEL;



//import jdk.nashorn.internal.ir.annotations.Immutable;

import javax.persistence.*;

@Entity
@Table(name="bayNew")
public class Bay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String name;
    private String bayId;
    private String surname;

    public Bay(String name, String bayId, String surname) {
        this.name = name;
        this.bayId = bayId;
        this.surname = surname;
    }

    public Bay() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBayId() {
        return bayId;
    }

    public void setBayId(String bayId) {
        this.bayId = bayId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
