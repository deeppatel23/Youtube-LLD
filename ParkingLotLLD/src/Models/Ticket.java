package Models;

import java.util.Date;

public class Ticket {
    String ticketId;
    Vehicle vehicle;
    int floorNumber;
    int slotNumber;
    Date issuerAt;

    public Ticket(String ticketId, Vehicle vehicle, int floorNumber, int slotNumber, Date issuerAt) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.issuerAt = issuerAt;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Date getIssuerAt() {
        return issuerAt;
    }

    public void setIssuerAt(Date issuerAt) {
        this.issuerAt = issuerAt;
    }
}
