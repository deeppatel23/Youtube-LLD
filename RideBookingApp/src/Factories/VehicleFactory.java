package Factories;

import Enums.VehicleType;
import Models.*;

public class VehicleFactory {
    public static Vehicle createVehicle (String registrationNumber, String model, String type, User owner) {
        VehicleType vehicleType;
        if (type.equalsIgnoreCase("bike")) {
            vehicleType = VehicleType.BIKE;
        } else if (type.equalsIgnoreCase("auto")) {
            vehicleType = VehicleType.AUTO;
        }
        else {
            vehicleType = VehicleType.CAR;
        }
        return switch (vehicleType) {
            case BIKE -> new Bike(registrationNumber, owner, model);
            case AUTO -> new Auto(registrationNumber, owner, model);
            case CAR -> new Car(registrationNumber, owner, model);
        };
    }
}
