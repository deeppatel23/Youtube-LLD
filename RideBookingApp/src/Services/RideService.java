package Services;

import Enums.RideStatus;
import Enums.VehicleType;
import Models.Location;
import Models.Ride;
import Models.User;
import Models.Vehicle;
import Strategies.RideSelectionStrategy;

import java.util.*;

public class RideService {
    Map<Integer, Ride> allRides;
    List<Ride>activeRides;
    UserService userService;

    public RideService(UserService userService) {
        this.userService = userService;
        allRides = new HashMap<>();
        activeRides = new ArrayList<>();
    }

    public Ride offerRide(String owner, String origin, String destination, int seats, String model, VehicleType vehicleType) {
        List<Vehicle>vehicles = userService.getVehicle(owner);
        for (Ride ride : activeRides) {
            if (ride.getVehicle().getModel().equalsIgnoreCase(model) && ride.getRideStatus().equals(RideStatus.IN_PROGRESS)) {
                System.out.println("Cannot offer ride. Already active for this vehicle.");
                return null;
            }
        }

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equalsIgnoreCase(model) && vehicle.getCapacity() >= seats && vehicle.getVehicleType() == vehicleType) {
                Location originLocation = new Location(0, 0, origin);
                Location destinationLocation = new Location(0, 0, destination);
                Ride ride = new Ride(owner, vehicle, originLocation, destinationLocation, seats);
                activeRides.add(ride);
                ride.setRideStatus(RideStatus.IN_PROGRESS);
                allRides.put(ride.getId(), ride);
                return ride;
            }
        }
        return null;
    }

    public Ride selectRide(String userName, String origin, String destination, int seats, RideSelectionStrategy strategy, VehicleType vehicleType) {
        List<Ride> available = new ArrayList<>();
        for (Ride ride : activeRides) {
            if (ride.getRideStatus().equals(RideStatus.IN_PROGRESS)
                    && ride.getOrigin().getAddress().equalsIgnoreCase(origin)
                    && ride.getDestination().getAddress().equalsIgnoreCase(destination)
                    && ride.getAvailableSeats() >= seats) {
                available.add(ride);
            }
        }
        Ride selected = strategy.selectRide(available, vehicleType);
        if (selected != null) {
            int remainingSeats = selected.getAvailableSeats();
            remainingSeats -= seats;
            selected.setAvailableSeats(remainingSeats);
            User user = userService.getUser(userName);
            int ridesTaken = user.getRidesTaken() + 1;
            user.setRidesTaken(ridesTaken);
            return selected;
        }
        return null;
    }

    public void endRide(int rideId) {
        if (allRides.containsKey(rideId)) {
            Ride ride = allRides.get(rideId);
            ride.setRideStatus(RideStatus.COMPLETED);
            activeRides.remove(ride);
            User user = userService.getUser(ride.getOwner());
            int ridesOffered = user.getRidesOffered()+1;
            user.setRidesOffered(ridesOffered);
        }
    }

    public void printStats() {
        for (User user : userService.users) {
            System.out.println(user.getName() + ": " + user.getRidesTaken() + " Taken, " + user.getRidesOffered() + " Offered");
        }
    }
}
