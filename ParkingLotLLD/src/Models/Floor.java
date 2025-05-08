package Models;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    int floorNumber;
    List<ParkingSlot>parkingSlotList;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSlotList = new ArrayList<>();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public void addParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlotList.add(parkingSlot);
    }
}
