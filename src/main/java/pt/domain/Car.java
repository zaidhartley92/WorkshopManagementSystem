package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Car {

    private String name;
    private String carId;
    private String licenseNumber;

    private Car(){}


    private Car(Builder builder) {
        this.name = builder.name;
        this.carId = builder.carId;
        this.licenseNumber = builder.licenseNumber;
    }

    public String getName() {
        return name;
    }

    public String getCarId() {
        return carId;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, carId, licenseNumber;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder carId(String carId) {
            this.carId = carId;
            return this;
        }

        public Builder licenseNumber(String licenseNumber) {
            this.licenseNumber = licenseNumber;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }

    @Override
    public String toString() {
        return " Car Name : " + name + "\n Car ID : " + carId + "\n Car License Number : " + licenseNumber;
    }
}