package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class TraineeMechanic {

    private String name;
    private String traineeMechanicId;
    private String surname;

    private TraineeMechanic(){}


    private TraineeMechanic(Builder builder) {
        this.name = builder.name;
        this.traineeMechanicId = builder.traineeMechanicId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getTraineeMechanicId() {
        return traineeMechanicId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, traineeMechanicId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder traineeMechanicId(String traineeMechanicId) {
            this.traineeMechanicId = traineeMechanicId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public TraineeMechanic build() {
            return new TraineeMechanic(this);
        }

    }

    @Override
    public String toString() {
        return " traineeMechanic Name : " + name + "\n traineeMechanic ID : " + traineeMechanicId + "\n Surname : " + surname;
    }
}