package design.pl;

public class Invoice {
    private final long costInCents;

    public Invoice(long costInCent) {
        this.costInCents = costInCent;
    }

    public long getCostInCents() {
        return costInCents;
    }
}
