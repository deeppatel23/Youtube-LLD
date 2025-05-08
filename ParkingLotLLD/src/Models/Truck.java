package Models;

import Enums.VehicleType;

public class Truck extends Vehicle{
    public Truck(String registrationNumber, String color) {
        super(registrationNumber, VehicleType.TRUCK, color);
    }
}
