package Models;

import Enums.VehicleType;

public class Car extends Vehicle{
    public Car(String registrationNumber, User user, String model) {
        super(registrationNumber, VehicleType.CAR, user, model, 4);
    }
}
