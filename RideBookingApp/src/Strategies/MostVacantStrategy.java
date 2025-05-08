package Strategies;

import Enums.VehicleType;
import Models.Ride;

import java.util.Comparator;
import java.util.List;

public class MostVacantStrategy implements RideSelectionStrategy{

    @Override
    public Ride selectRide(List<Ride> availableRides, VehicleType vehicleType) {
        return availableRides
                .stream()
                .max(Comparator.comparingInt(Ride::getAvailableSeats))
                .orElse(null);
    }
}
