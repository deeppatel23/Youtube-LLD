package Models;

import Enums.RideStatus;

public class Ride {
    static int idCounter = 0;
    final int id;
    final String owner;
    final Vehicle vehicle;
    final Location origin;
    final Location destination;
    int availableSeats;
    RideStatus rideStatus;

    public Ride(String owner, Vehicle vehicle, Location origin, Location destination, int availableSeats) {
        this.id = ++idCounter;
        this.owner = owner;
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.rideStatus = null;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Ride.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
