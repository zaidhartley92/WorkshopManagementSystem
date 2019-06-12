package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Door {

    private String name;
    private String doorId;
    private String surname;

    private Door(){}


    private Door(Builder builder) {
        this.name = builder.name;
        this.doorId = builder.doorId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getDoorId() {
        return doorId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, doorId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder doorId(String doorId) {
            this.doorId = doorId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Door build() {
            return new Door(this);
        }

    }

    @Override
    public String toString() {
        return " door Name : " + name + "\n door ID : " + doorId + "\n Surname : " + surname;
    }
}