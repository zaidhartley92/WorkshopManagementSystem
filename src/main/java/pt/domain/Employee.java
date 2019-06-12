package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Employee {

    private String name;
    private String employeeId;
    private String surname;

     Employee(){}


    private Employee(Builder builder) {
        this.name = builder.name;
        this.employeeId = builder.employeeId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, employeeId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }

    @Override
    public String toString() {
        return " Employee Name : " + name + "\n Employee ID : " + employeeId + "\n Surname : " + surname;
    }
}