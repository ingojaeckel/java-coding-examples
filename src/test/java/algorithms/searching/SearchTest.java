package algorithms.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest {
    private Search<Integer, String> search;

    @BeforeMethod
    public void setup() {
        this.search = new BinarySearch<>();
    }

    @Test
    public void emptyList() {
        assertNull(search.find(Collections.<Entry<Integer, String>>emptyList(), 1));
    }

    @Test(dataProvider = "list")
    public void doesNotExist(List<Entry<Integer, String>> list) {
        assertNull(search.find(list, 8));
    }

    @Test(dataProvider = "list")
    public void testSearch(List<Entry<Integer, String>> list) {
        assertEquals(search.find(list, 1), "a");
        assertEquals(search.find(list, 10), "b");
        assertEquals(search.find(list, 3), "c");
        assertEquals(search.find(list, 5), "d");
        assertEquals(search.find(list, 7), "e");

    }

    @DataProvider(name = "list")
    private Object[][] testData() {
        List<Entry<Integer, String>> list = new ArrayList<>();
        list.add(new Entry<Integer, String>(1, "a"));
        list.add(new Entry<Integer, String>(10, "b"));
        list.add(new Entry<Integer, String>(3, "c"));
        list.add(new Entry<Integer, String>(5, "d"));
        list.add(new Entry<Integer, String>(7, "e"));

        return new Object[][] {new Object[] {list}};
    }
}
