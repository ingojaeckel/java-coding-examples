package design.pl;

public class ParkingSpace {
    private ParkingTicket ticket;

    public boolean isAvailable() {
        return ticket == null;
    }

    public void claim(ParkingTicket ticket) {
        this.ticket = ticket;
    }

    public void unassign() {
        this.ticket = null;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }
}
