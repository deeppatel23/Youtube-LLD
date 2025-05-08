package Strategies;

import Enums.VehicleType;
import Models.Ride;

import java.util.List;

public class PreferredVehicleStrategy implements RideSelectionStrategy{
    @Override
    public Ride selectRide(List<Ride> availableRides, VehicleType vehicleType) {
        return availableRides
                .stream()
                .filter(ride -> ride.getVehicle().getVehicleType().equals(vehicleType))
                .findFirst()
                .orElse(null);
    }
}
