package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Mechanic {

    private String name;
    private String mechanicId;
    private String surname;

    private Mechanic(){}


    private Mechanic(Builder builder) {
        this.name = builder.name;
        this.mechanicId = builder.mechanicId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getMechanicId() {
        return mechanicId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, mechanicId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder mechanicId(String mechanicId) {
            this.mechanicId = mechanicId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Mechanic build() {
            return new Mechanic(this);
        }

    }

    @Override
    public String toString() {
        return " mechanic Name : " + name + "\n mechanic ID : " + mechanicId + "\n Surname : " + surname;
    }
}