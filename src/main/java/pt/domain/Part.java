package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Part {

    private String name;
    private String partId;
    private String surname;

    private Part(){}


    private Part(Builder builder) {
        this.name = builder.name;
        this.partId = builder.partId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getPartId() {
        return partId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, partId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder partId(String partId) {
            this.partId = partId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Part build() {
            return new Part(this);
        }

    }

    @Override
    public String toString() {
        return " part Name : " + name + "\n part ID : " + partId + "\n Surname : " + surname;
    }
}