package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Customer {

    private String name;
    private String customerId;
    private String surname;

    private Customer(){}


    private Customer(Builder builder) {
        this.name = builder.name;
        this.customerId = builder.customerId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, customerId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }

    }

    @Override
    public String toString() {
        return " customer Name : " + name + "\n customer ID : " + customerId + "\n Surname : " + surname;
    }
}
