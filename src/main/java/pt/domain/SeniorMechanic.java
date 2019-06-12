package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class SeniorMechanic {

    private String name;
    private String seniorMechanicId;
    private String surname;

    private SeniorMechanic(){}


    private SeniorMechanic(Builder builder) {
        this.name = builder.name;
        this.seniorMechanicId = builder.seniorMechanicId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getSeniorMechanicId() {
        return seniorMechanicId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, seniorMechanicId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder seniorMechanicId(String seniorMechanicId) {
            this.seniorMechanicId = seniorMechanicId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public SeniorMechanic build() {
            return new SeniorMechanic(this);
        }

    }

    @Override
    public String toString() {
        return " seniorMechanic Name : " + name + "\n seniorMechanic ID : " + seniorMechanicId + "\n Surname : " + surname;
    }
}