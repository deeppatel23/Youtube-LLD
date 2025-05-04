package Strategies;

import Enums.VehicleType;
import Models.Ride;

import java.util.List;

public interface RideSelectionStrategy {
    Ride selectRide(List<Ride> availableRides, VehicleType vehicleType);
}
