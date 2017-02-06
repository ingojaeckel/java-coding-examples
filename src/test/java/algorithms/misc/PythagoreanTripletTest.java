package algorithms.misc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PythagoreanTripletTest {
    @Test
    public void testPositive() {
        PythagoreanTriplet.Result r = new PythagoreanTriplet().find(3, 1, 4, 6, 5);
        Assert.assertTrue(r.exists());
        Assert.assertEquals(r.getA(), 3);
        Assert.assertEquals(r.getB(), 4);
        Assert.assertEquals(r.getC(), 5);
    }

    @Test
    public void testNegative() {
        Assert.assertFalse(new PythagoreanTriplet().find(3, 1, 6, 5).exists());
    }
}
