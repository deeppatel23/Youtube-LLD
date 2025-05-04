package Models;

import Enums.VehicleType;

public class Bike extends Vehicle {

    public Bike(String registrationNumber, User user, String model) {
        super(registrationNumber, VehicleType.BIKE, user, model, 1);
    }
}
