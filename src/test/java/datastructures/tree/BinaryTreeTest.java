package datastructures.tree;

import org.testng.annotations.Test;

import datastructures.Collection;
import datastructures.trees.BinaryTree;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class BinaryTreeTest {
    @Test
    public void testTree() {
        Collection<Integer, String> tree = new BinaryTree<>();
        assertNull(tree.get(1));

        testInsertGet(tree, 3, "foo");
        testInsertGet(tree, 2, "bar");
        testInsertGet(tree, 1, "baz");
        testInsertGet(tree, 4, "charlie");

        System.out.println(tree.traverse());
    }

    private <K extends Comparable<K>, V> void testInsertGet(Collection<K, V> tree, K key, V value) {
        assertNull(tree.insert(key, value));
        assertEquals(tree.get(key), value);
    }
}
