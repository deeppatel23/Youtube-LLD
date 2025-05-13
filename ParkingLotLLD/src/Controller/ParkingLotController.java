package Controller;


import Enums.VehicleType;
import Exceptions.InvalidFloorNumberException;
import Exceptions.NoAvailableSlotException;
import Models.Floor;
import Models.ParkingSlot;
import Models.Ticket;
import Models.Vehicle;
import Service.ParkingLotManager;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLotController {
    private final ParkingLotManager parkingLotManager;

    public ParkingLotController(String parkingLotId) {
        this.parkingLotManager = new ParkingLotManager(parkingLotId);
        System.out.println("Created ParkingLot: " + parkingLotId);
    }

    public void addFloor() {
        int floorNumber = parkingLotManager.getFloors().size() + 1;
        Floor floor = new Floor(floorNumber);
        parkingLotManager.addFloor(floor);
        System.out.println("Added floor " + floorNumber);
    }

    public void addSlot(int floorNumber, VehicleType slotType) {
        if (floorNumber < 1 || floorNumber > parkingLotManager.getFloors().size()) {
            throw new InvalidFloorNumberException(String.valueOf(floorNumber));
        }

        Floor floor = parkingLotManager.getFloors().get(floorNumber - 1);
        int slotNumber = floor.getParkingSlotList().size() + 1;
        ParkingSlot slot = new ParkingSlot(slotNumber, slotType);
        floor.addParkingSlot(slot);
        System.out.println("Added slot " + slotNumber + " on floor " + floorNumber + " for " + slotType);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        Optional<Ticket> ticket = parkingLotManager.parkVehicle(vehicle);
        if (ticket.isPresent()) {
            System.out.println("Parked vehicle. Ticket ID: " + ticket.get().getTicketId());
            return ticket.get();
        } else {
            throw new NoAvailableSlotException(vehicle.getVehicleType());
        }
    }

    public Vehicle unParkVehicle(Ticket ticket) {
        Optional<Vehicle> vehicle = parkingLotManager.unParkVehicle(ticket);
        if (vehicle.isPresent()) {
            System.out.println("Unparked vehicle with Registration Number: " +
                    vehicle.get().getRegistrationNumber());
            return vehicle.get();
        } else {
            System.out.println("Invalid ticket ID");
            return null;
        }
    }

    public void displayFreeSlotsCount(VehicleType type) {
        System.out.println("Displaying free slots count for type: " + type);
        Map<Integer, List<ParkingSlot>> freeSlotsCount = parkingLotManager.getAllFreeSlotsPerFloorPerVehicleType(type);
        for (Map.Entry<Integer, List<ParkingSlot>> entry : freeSlotsCount.entrySet()) {
            System.out.print("Floor " + entry.getKey() + ": ");
            System.out.println(entry.getValue().size());
        }
    }

    public void displayFreeSlots(VehicleType type) {
        System.out.println("Displaying free slots for type: " + type);
        Map<Integer, List<ParkingSlot>> freeSlotsCount = parkingLotManager.getAllFreeSlotsPerFloorPerVehicleType(type);
        for (Map.Entry<Integer, List<ParkingSlot>> entry : freeSlotsCount.entrySet()) {
            System.out.print("Floor " + entry.getKey() + ", Parking Slots: ");
            for (ParkingSlot slot : entry.getValue()) {
                System.out.print(slot.getSlotNumber() + " ");
            }
            System.out.println();
        }
    }

    public void displayOccupiedSlotsCount(VehicleType type) {
        System.out.println("Displaying occupied slots count for type: " + type);
        Map<Integer, List<ParkingSlot>> occupiedSlots = parkingLotManager.getAllOccupiedSlotsPerFloorPerVehicleType(type);
        for (Map.Entry<Integer, List<ParkingSlot>> entry : occupiedSlots.entrySet()) {
            System.out.print("Floor " + entry.getKey() + ": ");
            System.out.println(entry.getValue().size());
        }
    }

    public void displayOccupiedSlots(VehicleType type) {
        System.out.println("Displaying occupied slots for type: " + type);
        Map<Integer, List<ParkingSlot>> occupiedSlots = parkingLotManager.getAllOccupiedSlotsPerFloorPerVehicleType(type);
        for (Map.Entry<Integer, List<ParkingSlot>> entry : occupiedSlots.entrySet()) {
            System.out.print("Floor " + entry.getKey() + ", Parking Slots: ");
            for (ParkingSlot slot : entry.getValue()) {
                System.out.print(slot.getSlotNumber() + " ");
            }
            System.out.println();
        }
    }
}
