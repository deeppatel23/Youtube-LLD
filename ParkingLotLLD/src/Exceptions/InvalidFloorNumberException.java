package Exceptions;

public class InvalidFloorNumberException extends RuntimeException {
    public InvalidFloorNumberException(String floorNumber) {
        super("Invalid Floor Number: " + floorNumber);
    }
}
