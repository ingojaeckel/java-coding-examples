package datastructures.lists;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import datastructures.Collection;

public class SortedLinkedListTest {
    private Collection<Integer, String> list;

    @BeforeMethod
    public void setup() {
        this.list = new SortedLinkedList<>();
    }

    @Test
    public void getNonExistingItem() {
        Assert.assertNull(list.get(1));
    }

    @Test
    public void getExistingItem() {
        Assert.assertNull(list.insert(1, "one"));
        Assert.assertNull(list.insert(2, "two"));
        Assert.assertNull(list.insert(3, "three"));

        Assert.assertEquals(list.get(1), "one");
        Assert.assertEquals(list.get(2), "two");
        Assert.assertEquals(list.get(3), "three");
    }

    @Test
    public void testInsert() {
        Assert.assertEquals(list.size(), 0);

        Assert.assertNull(list.insert(1, "one"));
        Assert.assertEquals(list.size(), 1);
        Assert.assertNull(list.insert(3, "three"));
        Assert.assertEquals(list.size(), 2);
        Assert.assertNull(list.insert(5, "five"));
        Assert.assertEquals(list.size(), 3);

        Assert.assertNull(list.insert(2, "two"));
        Assert.assertEquals(list.size(), 4);
        Assert.assertNull(list.insert(4, "four"));
        Assert.assertEquals(list.size(), 5);

        Assert.assertEquals(list.insert(2, "two#2"), "two");
        Assert.assertEquals(list.size(), 5);
        Assert.assertEquals(list.insert(4, "four#2"), "four");
        Assert.assertEquals(list.size(), 5);
    }

    @Test
    public void testTraversal() {
        list.insert(1, "one");
        list.insert(2, "two");
        Assert.assertEquals(list.traverse(), "[1/one 2/two]");
    }
}
