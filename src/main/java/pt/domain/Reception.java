package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Reception {

    private String name;
    private String secretaryId;
    private String surname;

    private Reception(){}

    private Reception(Builder builder) {
        this.name = builder.name;
        this.secretaryId = builder.secretaryId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getSecretaryId() {
        return secretaryId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, secretaryId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder secretaryId(String secretaryId) {
            this.secretaryId = secretaryId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Reception build() {
            return new Reception(this);
        }

    }

    @Override
    public String toString() {
        return " secretary Name : " + name + "\n secretary ID : " + secretaryId + "\n Surname : " + surname;
    }
}