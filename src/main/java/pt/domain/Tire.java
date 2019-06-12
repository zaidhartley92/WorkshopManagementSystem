package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Tire {

    private String name;
    private String tireId;
    private String surname;

    private Tire(){}


    private Tire(Builder builder) {
        this.name = builder.name;
        this.tireId = builder.tireId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getTireId() {
        return tireId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, tireId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder tireId(String tireId) {
            this.tireId = tireId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Tire build() {
            return new Tire(this);
        }

    }

    @Override
    public String toString() {
        return " tire Name : " + name + "\n tire ID : " + tireId + "\n Surname : " + surname;
    }
}