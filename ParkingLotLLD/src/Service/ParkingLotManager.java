package Service;

import Enums.VehicleType;
import Models.*;

import java.util.*;

public class ParkingLotManager {
    ParkingLot parkingLot;

    public ParkingLotManager(String parkingLotId) {
        this.parkingLot = new ParkingLot(parkingLotId);
    }

    public void addFloor(Floor floor) {
        parkingLot.addFloor(floor);
    }

    public Map<Integer, List<ParkingSlot>> getAllFreeSlotsPerFloorPerVehicleType(VehicleType vehicleType) {
        Map<Integer, List<ParkingSlot>>freeSlotsCount = new HashMap<>();
        for (Floor floor : parkingLot.getFloors()) {
            List<ParkingSlot>parkingSlotList = new ArrayList<>();
            for (ParkingSlot parkingSlot : floor.getParkingSlotList()) {
                if (!parkingSlot.isOccupied() && parkingSlot.getSlotType() == vehicleType) {
                    parkingSlotList.add(parkingSlot);
                }
            }
            freeSlotsCount.put(floor.getFloorNumber(), parkingSlotList);
        }
        return freeSlotsCount;
    }

    public Map<Integer, List<ParkingSlot>> getAllOccupiedSlotsPerFloorPerVehicleType(VehicleType vehicleType) {
        Map<Integer, List<ParkingSlot>>freeSlotsCount = new HashMap<>();
        for (Floor floor : parkingLot.getFloors()) {
            List<ParkingSlot>parkingSlotList = new ArrayList<>();
            for (ParkingSlot parkingSlot : floor.getParkingSlotList()) {
                if (parkingSlot.isOccupied() && parkingSlot.getSlotType() == vehicleType) {
                    parkingSlotList.add(parkingSlot);
                }
            }
            freeSlotsCount.put(floor.getFloorNumber(), parkingSlotList);
        }
        return freeSlotsCount;
    }

    public Optional<Ticket> parkVehicle (Vehicle vehicle) {
        for (Floor floor : parkingLot.getFloors()) {
            for (ParkingSlot parkingSlot : floor.getParkingSlotList()) {
                if (!parkingSlot.isOccupied() && parkingSlot.getSlotType() == vehicle.getVehicleType()) {
                    parkingSlot.setParkedVehicle(vehicle);
                    parkingSlot.setOccupied(true);
                    String ticketId = parkingLot.getParkingLotId() + " Floor number: " + floor.getFloorNumber() + " Slot number: " + parkingSlot.getSlotNumber();
                    Ticket ticket = new Ticket(ticketId, vehicle, floor.getFloorNumber(), parkingSlot.getSlotNumber(), new Date());
                    parkingLot.addActiveTicket(ticket);
                    return Optional.of(ticket);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Vehicle> unParkVehicle (Ticket ticket) {
        for (Floor floor : parkingLot.getFloors()) {
            if (floor.getFloorNumber() == ticket.getFloorNumber()) {
                for (ParkingSlot parkingSlot : floor.getParkingSlotList()) {
                    if (parkingSlot.getSlotNumber() == ticket.getSlotNumber()) {
                        parkingSlot.setOccupied(false);
                        parkingSlot.setParkedVehicle(null);
                        parkingLot.removeActiveTicket(ticket);
                        return Optional.of(ticket.getVehicle());
                    }
                }
            }
        }
        return Optional.empty();
    }

    public String getParkingLotId() {
        return parkingLot.getParkingLotId();
    }

    public void setParkingLotId(String parkingLotId) {
        parkingLot.setParkingLotId(parkingLotId);
    }

    public List<Floor> getFloors() {
        return parkingLot.getFloors();
    }

    public void setFloors(List<Floor> floors) {
        parkingLot.setFloors(floors);
    }

    public List<Ticket> getActiveTickets() {
        return parkingLot.getActiveTickets();
    }

    public void setActiveTickets(List<Ticket> activeTickets) {
        parkingLot.setActiveTickets(activeTickets);
    }
}
