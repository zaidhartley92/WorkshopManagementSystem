package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Engine {

    private String name;
    private String engineId;
    private String surname;

    private Engine(){}


    private Engine(Builder builder) {
        this.name = builder.name;
        this.engineId = builder.engineId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getEngineId() {
        return engineId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, engineId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder engineId(String engineId) {
            this.engineId = engineId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Engine build() {
            return new Engine(this);
        }

    }

    @Override
    public String toString() {
        return " engine Name : " + name + "\n engine ID : " + engineId + "\n Surname : " + surname;
    }
}

