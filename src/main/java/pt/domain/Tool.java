package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Tool {

    private String name;
    private String toolId;
    private String surname;

    private Tool(){}


    private Tool(Builder builder) {
        this.name = builder.name;
        this.toolId = builder.toolId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getToolId() {
        return toolId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, toolId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder toolId(String toolId) {
            this.toolId = toolId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Tool build() {
            return new Tool(this);
        }

    }

    @Override
    public String toString() {
        return " tool Name : " + name + "\n tool ID : " + toolId + "\n Surname : " + surname;
    }
}