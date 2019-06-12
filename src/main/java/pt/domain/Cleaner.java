package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Cleaner {

    private String name;
    private String cleanerId;
    private String surname;

    private Cleaner(){}


    private Cleaner(Builder builder) {
        this.name = builder.name;
        this.cleanerId = builder.cleanerId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getCleanerId() {
        return cleanerId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, cleanerId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cleanerId(String cleanerId) {
            this.cleanerId = cleanerId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Cleaner build() {
            return new Cleaner(this);
        }

    }

    @Override
    public String toString() {
        return " cleaner Name : " + name + "\n cleaner ID : " + cleanerId + "\n Surname : " + surname;
    }
}
