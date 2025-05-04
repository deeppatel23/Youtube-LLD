package Models;

import Enums.VehicleType;

public class Auto extends Vehicle{
    public Auto(String registrationNumber, User user, String model) {
        super(registrationNumber, VehicleType.AUTO, user, model, 3);
    }
}
