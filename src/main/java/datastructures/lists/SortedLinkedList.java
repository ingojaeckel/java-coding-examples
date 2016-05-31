package datastructures.lists;

import datastructures.Collection;

public class SortedLinkedList<K extends Comparable<K>, V> implements Collection<K, V> {
    private Node<K, V> head;

    @Override
    public V insert(final K key, final V value) {
        final Node<K, V> newNode = new Node<>(key, value);

        if (head == null) {
            // Create the head.
            head = newNode;
            return null;
        }
        final int compare = key.compareTo(head.key);
        if (compare == 0) {
            // Update the value of the current head.
            V previousValue = head.value;
            head.value = value;
            return previousValue;
        }
        if (compare < 0) {
            // Insert a new head in front of the current head.
            Node<K, V> backup = head;
            head = newNode;
            head.next = backup;
            return null;
        }

        // Precondition: head != null && key > head.key.
        Node<K, V> node = head;

        while (node != null) {
            if (node.key == key) {
                // Just update the value of an existing element.
                V previousValue = node.value;
                node.value = value;
                return previousValue;
            }
            if (node.next == null) {
                // Insert a new tail.
                node.next = newNode;
                return null;
            }
            if (key.compareTo(node.next.key) < 0) {
                // Insert the new node between node and node.next.
                Node<K, V> bak = node.next;
                node.next = newNode;
                newNode.next = bak;
                return null;
            }
            // node.next must be != null and key >= node.next.key. Continue search.
            node = node.next;
        }

        throw new RuntimeException("Should never reach this point.");
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public V get(K key) {
        for (Node<K, V> node = head; node != null; node = node.next) {
            if (key.compareTo(node.key) == 0) {
                return node.value;
            }
        }

        return null;
    }

    @Override
    public String traverse() {
        StringBuilder builder = new StringBuilder("[");
        for (Node<K, V> node = head; node != null; node = node.next) {
            builder.append(node.key);
            builder.append("/");
            builder.append(node.value);


            if (node.next != null) {
                builder.append(" ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int size() {
        int size = 0;

        for (Node<K, V> node = head; node != null; node = node.next) {
            size++;
        }

        return size;
    }

    private static class Node<K extends Comparable<K>, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
