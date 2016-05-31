package datastructures.trees;

import datastructures.Collection;

public class RedBlackTree<K extends Comparable<K>, V> implements Collection<K, V> {
    private Node<K, V> root;

    @Override
    public V insert(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value, Color.Black);
            return null;
        }

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V remove(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String traverse() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    private static enum Color {
        Red, Black
    }
    
    private static class Node<K extends Comparable<K>, V> {
        private final Color color;
        private final K key;
        private final V value;
        private Node<K, V> left;
        private Node<K, V> right;
        private Node<K, V> parent;

        public Node(K key, V value, Color color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }
}
