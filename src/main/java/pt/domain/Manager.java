package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Manager {

    private String name;
    private String managerId;
    private String surname;

    private Manager(){}


    private Manager(Builder builder) {
        this.name = builder.name;
        this.managerId = builder.managerId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getManagerId() {
        return managerId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, managerId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder managerId(String managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Manager build() {
            return new Manager(this);
        }

    }

    @Override
    public String toString() {
        return " manager Name : " + name + "\n manager ID : " + managerId + "\n Surname : " + surname;
    }
}