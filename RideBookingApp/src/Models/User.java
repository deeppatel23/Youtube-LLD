package Models;

import Enums.Gender;
import Enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    int id;
    Gender gender;
    int age;
    List<Vehicle> vehicles;
    int ridesOffered;
    int ridesTaken;

    public User(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        vehicles = new ArrayList<>();
        ridesOffered = 0;
        ridesTaken = 0;
    }

    public User(String name, int id, Gender gender, int age) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        vehicles = new ArrayList<>();
        ridesOffered = 0;
        ridesTaken = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getRidesOffered() {
        return ridesOffered;
    }

    public void setRidesOffered(int ridesOffered) {
        this.ridesOffered = ridesOffered;
    }

    public int getRidesTaken() {
        return ridesTaken;
    }

    public void setRidesTaken(int ridesTaken) {
        this.ridesTaken = ridesTaken;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }


}
