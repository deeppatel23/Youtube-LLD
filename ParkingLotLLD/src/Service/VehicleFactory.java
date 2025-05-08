package Service;

import Enums.VehicleType;
import Models.Bike;
import Models.Car;
import Models.Truck;
import Models.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType, String registrationNumber, String color) {
        switch (vehicleType) {
            case CAR:
                return new Car(registrationNumber, color);
            case BIKE:
                return new Bike(registrationNumber, color);
            case TRUCK:
                return new Truck(registrationNumber, color);
            default:
                throw new IllegalArgumentException("Unknown vehicle type " + vehicleType);
        }
    }
}
