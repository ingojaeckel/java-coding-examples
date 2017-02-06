package datastructures.lists;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedListTest {
    private LinkedList<Integer> list;

    @BeforeMethod
    public void setup() {
        this.list = new LinkedList<>();
    }

    @Test
    public void initialSize() {
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void addGetRemove() {
        list.add(1);
        Assert.assertEquals(list.size(), 1);
        Assert.assertEquals(list.get(0).intValue(), 1);
        list.remove(0);
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void addGetRemove2() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Assert.assertNull(list.get(99));

        Assert.assertEquals(list.size(), 4);
        Assert.assertEquals(list.get(0).intValue(), 1);
        Assert.assertEquals(list.get(1).intValue(), 2);
        Assert.assertEquals(list.get(2).intValue(), 3);
        Assert.assertEquals(list.get(3).intValue(), 4);

        list.remove(1);
        Assert.assertEquals(list.size(), 3);
        Assert.assertEquals(list.get(0).intValue(), 1);
        Assert.assertEquals(list.get(1).intValue(), 3);
        Assert.assertEquals(list.get(2).intValue(), 4);

        list.remove(0);
        Assert.assertEquals(list.size(), 2);
        Assert.assertEquals(list.get(0).intValue(), 3);
        Assert.assertEquals(list.get(1).intValue(), 4);

        list.remove(1);
        Assert.assertEquals(list.size(), 1);
        Assert.assertEquals(list.get(0).intValue(), 3);

        list.remove(0);
        Assert.assertEquals(list.size(), 0);
        Assert.assertNull(list.get(0));
    }
}
