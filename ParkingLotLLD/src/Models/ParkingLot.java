package Models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String parkingLotId;
    List<Floor> floors;
    List<Ticket> activeTickets;

    public ParkingLot(String parkingLotId) {
        this.parkingLotId = parkingLotId;
        floors = new ArrayList<>();
        activeTickets = new ArrayList<>();
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

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public void addActiveTicket(Ticket ticket) {
        activeTickets.add(ticket);
    }

    public void removeActiveTicket(Ticket ticket) {
        activeTickets.remove(ticket);
    }

    public void removeFloor(Floor floor) {
        floors.remove(floor);
    }
}
