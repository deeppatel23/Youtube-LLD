package Models;

import Enums.VehicleType;

public class Vehicle {
    String registrationNumber;
    VehicleType vehicleType;
    User user;
    String model;
    int capacity;

    public Vehicle(String registrationNumber, VehicleType vehicleType, User user, String model, int capacity) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.user = user;
        this.model = model;
        this.capacity = capacity;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
