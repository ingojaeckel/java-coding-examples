package design.pl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BasicParkingLot implements ParkingLot {
    private final int centsPerHour;
    private final List<ParkingSpace> spaces;

    public BasicParkingLot(int numberOfSpaces, int centsPerHour) {
        this.centsPerHour = centsPerHour;
        this.spaces = new ArrayList<>(numberOfSpaces);

        for (int i=0; i<numberOfSpaces; i++) {
            spaces.add(new ParkingSpace());
        }
    }

    @Override
    public long capacity() {
        return spaces.stream().filter(p -> p.isAvailable()).count();
    }

    @Override
    public ParkingTicket enter() throws OutOfCapacityException {
        if (capacity() == 0) {
            throw new OutOfCapacityException();
        }
        return new ParkingTicket(UUID.randomUUID().toString(), System.currentTimeMillis());
    }

    @Override
    public void park(ParkingTicket ticket, int parkingSpaceIndex) throws IllegalArgumentException {
        if (parkingSpaceIndex < 0 || parkingSpaceIndex > spaces.size() - 1) {
            throw new IllegalArgumentException();
        }

        ParkingSpace space = spaces.get(parkingSpaceIndex);

        if (!space.isAvailable()) {
            throw new IllegalArgumentException();
        }

        space.claim(ticket);
    }

    @Override
    public Invoice leave(ParkingTicket ticket) {
        // Find the parking space associated with the ticket.
        Optional<ParkingSpace> optional = spaces.stream().filter(space -> {
            ParkingTicket t = space.getTicket();
            return t.getCode().equals(ticket.getCode());
        }).findFirst();

        if (!optional.isPresent()) {
            throw new IllegalArgumentException();
        }

        ParkingSpace space = optional.get();
        space.unassign();

        long durationHours = 1 + (ticket.getCreated() - System.currentTimeMillis()) / (1000 * 60 * 60);

        return new Invoice(durationHours * centsPerHour);
    }
}
