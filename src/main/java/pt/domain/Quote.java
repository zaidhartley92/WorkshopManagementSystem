package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Quote {

    private String name;
    private String quoteId;
    private Vehicle vehicle;
    private Bay bay;
    private Customer customer;
    private Employee employee;
    private Part part;

    private Quote(){}


    private Quote(Builder builder) {
        this.name = builder.name;
        this.quoteId = builder.quoteId;
        this.vehicle = builder.vehicle;
        this.bay = builder.bay;
        this.customer = builder.customer;
        this.employee = builder.employee;
        this.part = builder.part;
    }

    public String getName() {
        return name;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Bay getBay() {
        return bay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Part getPart() {
        return part;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, quoteId;
        private Vehicle vehicle;
        private Bay bay;
        private Customer customer;
        private Employee employee;
        private Part part;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder quoteId(String quoteId) {
            this.quoteId = quoteId;
            return this;
        }

        public Builder vehicle(Vehicle vehicle){
            this.vehicle = vehicle;
            return this;
        }

        public Builder bay(Bay bay){
            this.bay = bay;
            return this;
        }

        public Builder customer(Customer customer){
            this.customer = customer;
            return this;
        }

        public Builder employee(Employee employee){
            this.employee = employee;
            return this;
        }

        public Builder part(Part part){
            this.part = part;
            return this;
        }

        public Quote build() {
            return new Quote(this);
        }

    }

    @Override
    public String toString() {
        return " quote Name : " + name + "\n quote ID : " + quoteId +
                "\n vehicle : " + vehicle + "\n bay : " + bay +
                "\n customer : " + customer + "\n employee : " + employee + "\n part : " + part;
    }
}
