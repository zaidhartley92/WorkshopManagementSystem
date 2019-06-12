package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Bay {

    private String name;
    private String bayId;
    private String surname;

    private Bay(){}


    private Bay(Builder builder) {
        this.name = builder.name;
        this.bayId = builder.bayId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getBayId() {
        return bayId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }


    public static class Builder{

        private String name, bayId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder bayId(String bayId) {
            this.bayId = bayId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Bay build() {
            return new Bay(this);
        }

    }

    @Override
    public String toString() {
        return " bay Name : " + name + "\n bay ID : " + bayId + "\n Surname : " + surname;
    }
}