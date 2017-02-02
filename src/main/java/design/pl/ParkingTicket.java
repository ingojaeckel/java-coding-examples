package design.pl;

public class ParkingTicket {
    private final String code;
    private final long created;

    public ParkingTicket(String code, long created) {
        this.code = code;
        this.created = created;
    }

    public String getCode() {
        return code;
    }

    public long getCreated() {
        return created;
    }
}
