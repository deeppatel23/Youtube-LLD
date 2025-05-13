package Exceptions;

import Enums.VehicleType;

public class NoAvailableSlotException extends RuntimeException{
    public NoAvailableSlotException(VehicleType vehicleType) {
        super("No available slot for " + vehicleType);
    }
}
