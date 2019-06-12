package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class LoyalCustomer {

    private String name;
    private String loyalCustomerId;
    private String surname;

    private LoyalCustomer(){}


    private LoyalCustomer(Builder builder) {
        this.name = builder.name;
        this.loyalCustomerId = builder.loyalCustomerId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getLoyalCustomerId() {
        return loyalCustomerId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, loyalCustomerId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder loyalCustomerId(String loyalCustomerId) {
            this.loyalCustomerId = loyalCustomerId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public LoyalCustomer build() {
            return new LoyalCustomer(this);
        }

    }

    @Override
    public String toString() {
        return " loyalCustomer Name : " + name + "\n loyalCustomer ID : " + loyalCustomerId + "\n Surname : " + surname;
    }
}