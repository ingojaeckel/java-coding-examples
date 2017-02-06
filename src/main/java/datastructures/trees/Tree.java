package datastructures.trees;

import java.util.ArrayList;
import java.util.List;

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

        public List<K> traverse() {
            List<K> items = new ArrayList<>();
            if (left != null) {
                items.addAll(left.traverse());
            }
            items.add(value);
            if (right != null) {
                items.addAll(right.traverse());
            }
            return items;
        }

        public boolean allNodesBiggerThan(K value) {
            List<K> nodes = traverse();
            return nodes.size() == nodes.stream().filter(current -> value.compareTo(current) < 0).count();
        }

        public boolean allNodesSmallerThan(K value) {
            List<K> nodes = traverse();
            return nodes.size() == traverse().stream().filter(current -> value.compareTo(current) > 0).count();
        }

        public boolean isBinary() {
            if (left == null) {
                if (right == null) {
                    return true;
                }
                return value.compareTo(right.value) < 0 && right.allNodesBiggerThan(value) && right.isBinary();
            }

            if (right == null) {
                return left.value.compareTo(value) < 0 && left.allNodesSmallerThan(value) && left.isBinary();
            }

            return  left.value.compareTo(value) < 0 && value.compareTo(right.value) < 0 &&
                    left.allNodesSmallerThan(value) && right.allNodesBiggerThan(value) &&
                    left.isBinary() && right.isBinary();
        }
    }
}
