package design.pl;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParkingLotTest {
    private ParkingLot lot;
    private int initialCapacity = 3;
    private int centsPerHour = 100;

    @BeforeMethod
    public void before() {
        this.lot = new BasicParkingLot(initialCapacity, centsPerHour);
    }

    @Test
    public void lotStartsOutEmpty() {
        Assert.assertEquals(lot.capacity(), initialCapacity);
    }

    @DataProvider(name = "badIndices")
    public Object[][] badIndices() {
        return new Object[][]{new Object[]{-1}, new Object[]{initialCapacity}, new Object[]{initialCapacity + 1}};
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "badIndices")
    public void invalidParkIndices(int badIndex) throws OutOfCapacityException {
        ParkingTicket ticket = lot.enter();
        lot.park(ticket, badIndex);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void cannotParkAtTheSameSpaceTwice() throws OutOfCapacityException {
        ParkingTicket ticket = lot.enter();
        lot.park(ticket, 0);
        lot.park(ticket, 0);
    }

    @Test
    public void testPark() throws OutOfCapacityException {
        ParkingTicket ticket = lot.enter();
        lot.park(ticket, 0);

        Assert.assertEquals(lot.capacity(), initialCapacity - 1);
        Invoice invoice = lot.leave(ticket);
        Assert.assertEquals(lot.capacity(), initialCapacity);

        Assert.assertEquals(invoice.getCostInCents(), 1 * centsPerHour);
    }

    @Test
    public void useUpCapacity() throws OutOfCapacityException {
        ParkingTicket ticket1 = lot.enter();
        ParkingTicket ticket2 = lot.enter();
        ParkingTicket ticket3 = lot.enter();

        Assert.assertEquals(lot.capacity(), initialCapacity);
        lot.park(ticket1, 0);
        Assert.assertEquals(lot.capacity(), initialCapacity - 1);
        lot.park(ticket2, 1);
        Assert.assertEquals(lot.capacity(), initialCapacity - 2);
        lot.park(ticket3, 2);
        Assert.assertEquals(lot.capacity(), initialCapacity - 3); // out of capacity
    }

    @Test(expectedExceptions = OutOfCapacityException.class)
    public void enteringAboveCapacityFails()  throws OutOfCapacityException {
        useUpCapacity();
        lot.enter();
    }
}
