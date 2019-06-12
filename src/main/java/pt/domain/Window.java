package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Window {

    private String name;
    private String windowId;
    private String surname;

    private Window(){}


    private Window(Builder builder) {
        this.name = builder.name;
        this.windowId = builder.windowId;
        this.surname = builder.surname;
    }

    public String getName() {
        return name;
    }

    public String getWindowId() {
        return windowId;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String newName){
        name = newName;
    }

    public static class Builder{

        private String name, windowId, surname;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder windowId(String windowId) {
            this.windowId = windowId;
            return this;
        }

        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Window build() {
            return new Window(this);
        }

    }

    @Override
    public String toString() {
        return " window Name : " + name + "\n window ID : " + windowId + "\n Surname : " + surname;
    }
}