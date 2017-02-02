package design.pl;

public interface ParkingLot {
    long capacity();

    ParkingTicket enter() throws OutOfCapacityException;

    void park(ParkingTicket ticket, int parkingSpaceIndex) throws IllegalArgumentException;

    Invoice leave(ParkingTicket ticket);
}
