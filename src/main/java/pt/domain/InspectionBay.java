package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class InspectionBay {

    private String name;
    private String inspectionBayId;
    private String surname;

    private InspectionBay(){}


    private InspectionBay(Builder builder) {
        this.name = builder.name;
        this.inspectionBayId = builder.inspectionBayId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getInspectionBayId() {
        return inspectionBayId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, inspectionBayId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder inspectionBayId(String inspectionBayId) {
            this.inspectionBayId = inspectionBayId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public InspectionBay build() {
            return new InspectionBay(this);
        }

    }

    @Override
    public String toString() {
        return " inspectionBay Name : " + name + "\n inspectionBay ID : " + inspectionBayId + "\n Surname : " + surname;
    }
}