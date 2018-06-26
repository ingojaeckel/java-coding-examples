package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class SortedListMerger {
    /**
     * @return First element of a sorted List which is the result of merging the n given sorted lists. From https://leetcode.com/problems/merge-k-sorted-lists/description/.
     */
    public ListNode mergeNaive(ListNode[] lists) {
        ListNode newListFirstElement = null;
        ListNode newListLastElement = null;
        int numberOfFullyTraversedLists = 0;
        ListNode[] pointers = new ListNode[lists.length];

        for (int i=0; i<lists.length; i++) {
            pointers[i] = lists[i];
        }

        while (numberOfFullyTraversedLists < lists.length) {
            int idx = indexOfSmallestNode(pointers);
            ListNode newNode = new ListNode(pointers[idx].val);

            if (newListFirstElement == null) {
                // Inserting the first element.
                newListFirstElement = (newListLastElement = newNode);
            } else {
                // The new list already contains data
                newListLastElement.next = newNode;
                newListLastElement = newNode;
            }

            if (pointers[idx].next == null) {
                // Reached the end of another list
                numberOfFullyTraversedLists++;
            }
            pointers[idx] = pointers[idx].next;
        }

        return newListFirstElement;
    }

    private int indexOfSmallestNode(ListNode[] nodes) {
        int indexOfSmallestNode = 0;

        for (int i=1; i<nodes.length; i++) {
            if (nodes[indexOfSmallestNode] == null || // did this list already come to it's end?
                nodes[i].val < nodes[indexOfSmallestNode].val) {
                indexOfSmallestNode = i;
            }
        }

        return indexOfSmallestNode;
    }

    public static class ListNode {
        final int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public static ListNode from(int ... values) {
            ListNode first = new ListNode(values[0]);
            ListNode last = first;
            for (int i=1; i<values.length; i++) {
                ListNode newNode = new ListNode(values[i]);
                last.next = newNode;
                last = newNode;
            }
            return first;
        }

        public List<Integer> toList() {
            List<Integer> list = new ArrayList<>();
            list.add(val);
            for (ListNode node=next; node != null; node=node.next) {
                list.add(node.val);
            }
            return list;
        }
    }
}
