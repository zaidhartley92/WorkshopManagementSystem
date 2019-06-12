package pt.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ParkingBay {

    private String parkingBayName;
    private String parkingBayId;
    private boolean full;

    private ParkingBay(){}

    private ParkingBay(Builder builder) {
        this.parkingBayName = builder.parkingBayName;
        this.parkingBayId = builder.parkingBayId;
        this.full = builder.full;
    }

    public String getName() {
        return parkingBayName;
    }

    public boolean getFull() {
        return full;
    }

    public String getParkingBayId() {
        return parkingBayId;
    }

    public void setName(String newName){
        parkingBayName = newName;
    }

    public void isFull(boolean newFull){
        full = newFull;
    }

    public static class Builder{

        private String parkingBayName, parkingBayId;
        private boolean full;

        public Builder parkingBayName(String parkingBayName) {
            this.parkingBayName = parkingBayName;
            return this;
        }

        public Builder full(boolean full) {
            this.full = full;
            return this;
        }

        public Builder parkingId(String parkingId) {
            this.parkingBayId = parkingId;
            return this;
        }

        public ParkingBay build() {
            return new ParkingBay(this);
        }

    }

    @Override
    public String toString() {
        return " Parking Name : " + parkingBayName + "\n Parking ID : " + parkingBayId + "\n Is full? : " + full;
    }
}