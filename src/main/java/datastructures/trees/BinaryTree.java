package datastructures.trees;

import datastructures.Collection;

public class BinaryTree<K extends Comparable<K>, V> implements Collection<K, V> {
    private Node<K, V> root;

    @Override
    public V insert(K key, V value) {
        if (root == null) {
            root = new Node<>(key, value);
            return null;
        }
        return insert(root, key, value);
    }

    private V insert(Node<K, V> node, K key, V value) {
        int compare = key.compareTo(node.key);

        if (compare < 0) {
            if (node.left == null) {
                node.left = new Node<>(key, value);
                return null;
            }

            return insert(node.left, key, value);
        } else if (compare > 0) {
            if (node.right == null) {
                node.right = new Node<>(key, value);
                return null;
            }

            return insert(node.right, key, value);
        }

        // compare == 0
        V previousValue = node.value;
        node.value = value;
        return previousValue;
    }

    @Override
    public V remove(K key) {
        if (root == null) {
            return null;
        }

        if (key.compareTo(root.key) == 0) {
            V previousValue = root.value;
            root = null;
            return previousValue;
        }

        return remove(root, key);
    }

    private V remove(Node<K, V> node, K key) {
        int compare = key.compareTo(node.key);

        if (compare < 0) {
            if (node.left == null) {
                return null;
            }
            if (node.sameKeyAs(node.left)) {
                // TODO backup child nodes
                // Node<K, V> left = node.left.left;
                // Node<K, V> right = node.left.right;
                V previousValue = node.left.value;
                node.left = null;
                return previousValue;
            }
            return remove(node.left, key);
        } else if (compare > 0) {
            if (node.right == null) {
                return null;
            }
            if (node.sameKeyAs(node.right)) {
                V previousValue = node.right.value;
                node.right = null;
                return previousValue;
            }
            return remove(node.right, key);
        }

        // Should never reach this point.
        throw new IllegalArgumentException("Should never reach this point.");
    }

    @Override
    public V get(K key) {
        if (root == null) {
            return null;
        }

        return get(root, key);
    }

    private V get(Node<K, V> node, K key) {
        int compare = key.compareTo(node.key);

        if (compare < 0) {
            if (node.left == null) {
                return null;
            }

            return get(node.left, key);
        } else if (compare > 0) {
            if (node.right == null) {
                return null;
            }

            return get(node.right, key);
        }

        // compare == 0
        return node.value;
    }

    @Override
    public String traverse() {
        if (root == null) {
            return "{}";
        }

        return traverse(root, 0);
    }

    private String traverse(Node<K, V> node, int level) {
        String left = "{}";
        if (node.left != null) {
            left = traverse(node.left, level + 1);
        }
        String right = "{}";
        if (node.right != null) {
            right = traverse(node.right, level + 1);
        }

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < level; i++) {
            b.append("\t");
        }
        String tabs = b.toString();

        return String.format("%s -> %s%n%sL: %s%n%sR: %s%n", node.key, node.value, tabs, left, tabs, right);
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    private static class Node<K extends Comparable<K>, V> {
        private final K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean sameKeyAs(Node<K, V> node) {
            return key.compareTo(node.key) == 0;
        }
    }
}
