package com.example.demo.DTO;

public class BayDTO {
    private String name;
    private String bayId;
    private String surname;

    public BayDTO(String name, String bayId, String surname) {
        this.name = name;
        this.bayId = bayId;
        this.surname = surname;
    }

    public BayDTO() {
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
