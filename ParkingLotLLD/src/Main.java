import Controller.ParkingLotController;
import Enums.VehicleType;
import Models.Ticket;
import Models.Vehicle;
import Service.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        ParkingLotController controller = new ParkingLotController("ParkingLot-1");

        // Add floors to the parking lot
        controller.addFloor(); // Floor 1
        controller.addFloor(); // Floor 2

        // Add slots to floor 1
        controller.addSlot(1, VehicleType.TRUCK);
        controller.addSlot(1, VehicleType.BIKE);
        controller.addSlot(1, VehicleType.BIKE);
        controller.addSlot(1, VehicleType.CAR);
        controller.addSlot(1, VehicleType.CAR);

        // Add slots to floor 2
        controller.addSlot(2, VehicleType.TRUCK);
        controller.addSlot(2, VehicleType.BIKE);
        controller.addSlot(2, VehicleType.BIKE);
        controller.addSlot(2, VehicleType.CAR);

        // Park vehicles
        controller.displayFreeSlotsCount(VehicleType.CAR);
        controller.displayFreeSlots(VehicleType.CAR);
        Vehicle car1 = VehicleFactory.createVehicle(VehicleType.CAR, "MH-01-AB-1234", "Red");
        Ticket ticket1 = controller.parkVehicle(car1);
        controller.displayFreeSlotsCount(VehicleType.CAR);
        controller.displayFreeSlots(VehicleType.CAR);
        controller.displayOccupiedSlots(VehicleType.CAR);

        controller.displayFreeSlotsCount(VehicleType.BIKE);
        Vehicle bike1 = VehicleFactory.createVehicle(VehicleType.BIKE, "MH-01-AB-5678", "Blue");
        Ticket ticket2 = controller.parkVehicle(bike1);

        // Display free slots
        controller.displayFreeSlotsCount(VehicleType.CAR);
        controller.displayFreeSlotsCount(VehicleType.BIKE);

        // Unpark vehicle
        if (ticket1 != null) {
            controller.unParkVehicle(ticket1);
        }

        // Display free slots after unparking
        controller.displayFreeSlotsCount(VehicleType.CAR);
        controller.displayOccupiedSlotsCount(VehicleType.BIKE);

        controller.addSlot(5, VehicleType.TRUCK);
    }
}