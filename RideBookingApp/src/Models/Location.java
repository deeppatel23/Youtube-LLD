package Models;

public class Location {
    double latitude;
    double longitude;
    String address;

    public Location(double latitude, double longitude, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double distanceTo(Location other) {
        double latDiff = this.latitude - other.latitude;
        double longDiff = this.longitude - other.longitude;
        return Math.sqrt(latDiff * latDiff + longDiff * longDiff);
    }
}
