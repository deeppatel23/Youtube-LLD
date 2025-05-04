import Enums.VehicleType;
import Models.Ride;
import Services.RideService;
import Services.UserService;
import Strategies.MostVacantStrategy;
import Strategies.PreferredVehicleStrategy;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        RideService rideService = new RideService(userService);

        userService.addUser("Rohan", "M", 36);
        userService.addVehicle("Rohan", "Swift", "KA-01-12345", "car");
        userService.addUser("Shashank", "M", 29);
        userService.addVehicle("Shashank", "Baleno", "TS-05-62395", "car");
        userService.addUser("Nandini", "F", 29);
        userService.addUser("Shipra", "F", 27);
        userService.addVehicle("Shipra", "Polo", "KA-05-41491", "car");
        userService.addVehicle("Shipra", "Activa", "KA-12-12332", "bike");
        userService.addUser("Gaurav", "M", 29);
        userService.addUser("Rahul", "M", 35);
        userService.addVehicle("Rahul", "XUV", "KA-05-1234", "car");

        Ride r1 = rideService.offerRide("Rohan", "Hyderabad", "Bangalore", 1, "Swift", VehicleType.CAR);
        Ride r2 = rideService.offerRide("Shipra", "Bangalore", "Mysore", 1, "Activa", VehicleType.BIKE);
        Ride r3 = rideService.offerRide("Shipra", "Bangalore", "Mysore", 2, "Polo", VehicleType.CAR);
        Ride r4 = rideService.offerRide("Shashank", "Hyderabad", "Bangalore", 2, "Baleno", VehicleType.CAR);
        Ride r5 = rideService.offerRide("Rahul", "Hyderabad", "Bangalore", 5, "XUV", VehicleType.CAR);
        Ride r6 = rideService.offerRide("Rohan", "Bangalore", "Pune", 1, "Swift", VehicleType.CAR); // Should fail

        Ride sr1 = rideService.selectRide("Nandini", "Bangalore", "Mysore", 1, new MostVacantStrategy(), null);
        Ride sr2 = rideService.selectRide("Gaurav", "Bangalore", "Mysore", 1, new PreferredVehicleStrategy(), VehicleType.BIKE);
        Ride sr3 = rideService.selectRide("Shashank", "Mumbai", "Bangalore", 1, new MostVacantStrategy(), null);
        Ride sr4 = rideService.selectRide("Rohan", "Hyderabad", "Bangalore", 1, new PreferredVehicleStrategy(), VehicleType.CAR);
        Ride sr5 = rideService.selectRide("Shashank", "Hyderabad", "Bangalore", 1, new PreferredVehicleStrategy(), VehicleType.CAR);

        if (sr1 != null) rideService.endRide(sr1.getId());
        if (sr2 != null) rideService.endRide(sr2.getId());
        if (sr4 != null) rideService.endRide(sr4.getId());

        rideService.endRide(r3.getId()); // Ending unused offered ride

        rideService.printStats();
    }
}