package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Vehicle {

    private String name;
    private String vehicleId;
    private String surname;

    private Vehicle(){}


    private Vehicle(Builder builder) {
        this.name = builder.name;
        this.vehicleId = builder.vehicleId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, vehicleId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder vehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }

    }

    @Override
    public String toString() {
        return " vehicle Name : " + name + "\n vehicle ID : " + vehicleId + "\n Surname : " + surname;
    }
}
