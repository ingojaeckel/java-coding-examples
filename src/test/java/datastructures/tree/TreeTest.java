package datastructures.tree;

import datastructures.trees.Tree;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TreeTest {

    @Test
    public void testUsingTree() {
        Tree<Integer> tree = new Tree<>(new Tree.Node<>(2));
        tree.getRoot().setLeft(new Tree.Node(1));
        tree.getRoot().setRight(new Tree.Node(3));

        Assert.assertEquals(tree.getRoot().getValue().intValue(), 2);
        Assert.assertEquals(tree.getRoot().getLeft().getValue().intValue(), 1);
        Assert.assertEquals(tree.getRoot().getRight().getValue().intValue(), 3);

        Assert.assertTrue(tree.isBinary());
    }

    @Test
    public void testBinaryBaseCasePositive() {
        // left & right null
        Assert.assertTrue(new Tree.Node<>(1).isBinary());

        // left / right null
        Assert.assertTrue(new Tree.Node<>(2, null, new Tree.Node<>(3)).isBinary());
        Assert.assertTrue(new Tree.Node<>(2, new Tree.Node<>(1), null).isBinary());

        // left & right non-null
        Assert.assertTrue(new Tree.Node<>(2, new Tree.Node<>(1), new Tree.Node<>(3)).isBinary());
    }

    @Test
    public void testBinaryBaseCaseNegative() {
        Assert.assertFalse(new Tree.Node<>(2, null, new Tree.Node<>(1)).isBinary());
        Assert.assertFalse(new Tree.Node<>(2, new Tree.Node<>(3), null).isBinary());

        Assert.assertFalse(new Tree.Node<>(2, new Tree.Node<>(3), new Tree.Node<>(1)).isBinary());
    }
}
