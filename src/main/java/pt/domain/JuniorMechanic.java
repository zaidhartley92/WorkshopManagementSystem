package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class JuniorMechanic {

    private String name;
    private String juniorMechanicId;
    private String surname;

    private JuniorMechanic(){}


    private JuniorMechanic(Builder builder) {
        this.name = builder.name;
        this.juniorMechanicId = builder.juniorMechanicId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getJuniorMechanicId() {
        return juniorMechanicId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, juniorMechanicId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder juniorMechanicId(String juniorMechanicId) {
            this.juniorMechanicId = juniorMechanicId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public JuniorMechanic build() {
            return new JuniorMechanic(this);
        }

    }

    @Override
    public String toString() {
        return " juniorMechanic Name : " + name + "\n juniorMechanic ID : " + juniorMechanicId + "\n Surname : " + surname;
    }
}