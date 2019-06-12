package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class MechanicBay {

    private String name;
    private String mechanicBayId;
    private String surname;

    private MechanicBay(){}


    private MechanicBay(Builder builder) {
        this.name = builder.name;
        this.mechanicBayId = builder.mechanicBayId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getMechanicBayId() {
        return mechanicBayId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, mechanicBayId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder mechanicBayId(String mechanicBayId) {
            this.mechanicBayId = mechanicBayId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public MechanicBay build() {
            return new MechanicBay(this);
        }

    }

    @Override
    public String toString() {
        return " mechanicBay Name : " + name + "\n mechanicBay ID : " + mechanicBayId + "\n Surname : " + surname;
    }
}