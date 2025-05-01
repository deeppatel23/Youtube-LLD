package Service;

import Enums.VehicleType;
import Models.Floor;
import Models.ParkingSlot;
import Models.Ticket;
import Models.Vehicle;

import java.util.*;

public class ParkingLotManager {
    String parkingLotId;
    List<Floor> floors;
    List<Ticket> activeTickets;

    public ParkingLotManager(String parkingLotId) {
        this.parkingLotId = parkingLotId;
        floors = new ArrayList<>();
        activeTickets = new ArrayList<>();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public Map<Integer, List<ParkingSlot>> getAllFreeSlotsCountPerFloorPerVehicleType(VehicleType vehicleType) {
        Map<Integer, List<ParkingSlot>>freeSlotsCount = new HashMap<>();
        for (Floor floor : this.floors) {
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

    public Map<Integer, List<ParkingSlot>> getAllOccupiedSlotsCountPerFloorPerVehicleType(VehicleType vehicleType) {
        Map<Integer, List<ParkingSlot>>freeSlotsCount = new HashMap<>();
        for (Floor floor : this.floors) {
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
        for (Floor floor : floors) {
            for (ParkingSlot parkingSlot : floor.getParkingSlotList()) {
                if (!parkingSlot.isOccupied() && parkingSlot.getSlotType() == vehicle.getVehicleType()) {
                    parkingSlot.setParkedVehicle(vehicle);
                    parkingSlot.setOccupied(true);
                    String ticketId = parkingLotId + " Floor number: " + floor.getFloorNumber() + " Slot number: " + parkingSlot.getSlotNumber();
                    Ticket ticket = new Ticket(ticketId, vehicle, floor.getFloorNumber(), parkingSlot.getSlotNumber(), new Date());
                    activeTickets.add(ticket);
                    return Optional.of(ticket);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Vehicle> unParkVehicle (Ticket ticket) {
        for (Floor floor : floors) {
            if (floor.getFloorNumber() == ticket.getFloorNumber()) {
                for (ParkingSlot parkingSlot : floor.getParkingSlotList()) {
                    if (parkingSlot.getSlotNumber() == ticket.getSlotNumber()) {
                        parkingSlot.setOccupied(false);
                        parkingSlot.setParkedVehicle(null);
                        activeTickets.remove(ticket);
                        return Optional.of(ticket.getVehicle());
                    }
                }
            }
        }
        return Optional.empty();
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Ticket> getActiveTickets() {
        return activeTickets;
    }

    public void setActiveTickets(List<Ticket> activeTickets) {
        this.activeTickets = activeTickets;
    }
}
