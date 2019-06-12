package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Bike {

    private String name;
    private String bikeId;
    private String surname;

    private Bike(){}


    private Bike(Builder builder) {
        this.name = builder.name;
        this.bikeId = builder.bikeId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getBikeId() {
        return bikeId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, bikeId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder bikeId(String bikeId) {
            this.bikeId = bikeId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Bike build() {
            return new Bike(this);
        }

    }

    @Override
    public String toString() {
        return " bike Name : " + name + "\n bike ID : " + bikeId + "\n Surname : " + surname;
    }
}