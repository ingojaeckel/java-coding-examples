package algorithms.sorting;

import algorithms.sorting.SortedListMerger.ListNode;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SortedListMergerTest {
    @Test
    public void testMergeNaive() {
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(1);
        ListNode list3 = new ListNode(2);

        SortedListMerger.ListNode newList = new SortedListMerger().mergeNaive(new SortedListMerger.ListNode[]{list1, list2, list3});
        Assert.assertEquals(newList.val, 0);
        Assert.assertEquals(newList.next.val, 1);
        Assert.assertEquals(newList.next.next.val, 2);
        Assert.assertEquals(newList.next.next.next, null);
    }

    @Test
    public void testMergeNaive2() {
        ListNode list1 = ListNode.from(1, 2, 3, 5, 7);
        ListNode list2 = ListNode.from(0, 1, 2, 4, 6, 10);
        ListNode list3 = ListNode.from(0, 1, 3, 5, 7, 11);

        SortedListMerger.ListNode newListNode = new SortedListMerger().mergeNaive(new SortedListMerger.ListNode[]{list1, list2, list3});
        List<Integer> newList = new SortedListMerger().mergeNaive(new SortedListMerger.ListNode[]{list1, list2, list3}).toList();

        Assert.assertEquals(newList, Arrays.asList(0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 7, 10, 11));
    }
}
