package datastructures.lists;

public class LinkedList<V extends Comparable<V>> {

    private Node<V> head;

    public void add(V value) {
        if (head == null) {
            head = new Node<>();
            head.value = value;
            return;
        }

        Node<V> current = head;

        while (current != null) {
            if (current.next == null) {
                break;
            }
            current = current.next;
        }

        Node<V> newNode = new Node<>();
        newNode.value = value;

        current.next = newNode;
    }

    public V get(int index) {
        if (head == null) {
            return null;
        }

        if (index == 0) {
            return head.value;
        }

        Node<V> current = head;

        for (int i=1; i<=index; i++) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        if (current != null) {
            return current.value;
        }
        return null;
    }

    public V remove(int index) {
        if (head == null) {
            return null;
        }

        if (index == 0) {
            Node<V> tmp = head;
            head = head.next; // remove the head element
            return tmp.value;
        }

        Node<V> current = head;
        Node<V> prev = null;

        for (int i=1; i<=index; i++) {
            if (current.next == null) {
                return null;
            }
            prev = current;
            current = current.next;
        }
        if (current != null) {
            // skip the current element by pointing previous at the next element.
            prev.next = current.next;
            return current.value;
        }
        // current == null - could not find an element at this index.
        return null;
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        Node<V> current = head;
        int size = 1;

        while (current != null) {
            if (current.next == null) {
                return size;
            }
            current = current.next;
            size++;
        }
        return size;
    }

    private static class Node<V extends Comparable<V>> {
        private V value;
        private Node<V> next;
    }
}
