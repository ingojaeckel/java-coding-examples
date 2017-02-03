package datastructures.trees;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public Tree(Node<T> root) {
        this.root = root;
    }

    public boolean isBinary() {
        if (root == null) {
            return false;
        }
        return root.isBinary();
    }

    public Node<T> getRoot() {
        return root;
    }

    public static class Node<K extends Comparable<K>> {
        private final K value;
        private Node<K> left, right;

        public Node(K value) {
            this.value = value;
        }

        public Node(K value, Node<K> left, Node<K> right) {
            this(value);
            this.left = left;
            this.right = right;
        }

        public Node<K> getLeft() {
            return left;
        }

        public void setLeft(Node<K> left) {
            this.left = left;
        }

        public Node<K> getRight() {
            return right;
        }

        public void setRight(Node<K> right) {
            this.right = right;
        }

        public K getValue() {
            return value;
        }

        public boolean isBinary() {
            if (left == null) {
                if (right == null) {
                    return true;
                }
                return value.compareTo(right.getValue()) < 0;
            }

            if (right == null) {
                return left.getValue().compareTo(value) < 0;
            }

            return left.getValue().compareTo(value) < 0 && value.compareTo(right.getValue()) < 0;
        }
    }
}
