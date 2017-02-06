package datastructures.tree;

import datastructures.trees.Tree;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

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

        // multiple layers
        //         4
        //   (2    ,    6)
        // (1 , 3)   (5 , 7)
        Assert.assertTrue(new Tree.Node<>(4,
            new Tree.Node<>(2, new Tree.Node<>(1), new Tree.Node<>(3)),
            new Tree.Node<>(6, new Tree.Node<>(5), new Tree.Node<>(7))).isBinary());
    }

    @Test
    public void testBinaryBaseCaseNegative() {
        Assert.assertFalse(new Tree.Node<>(2, null, new Tree.Node<>(1)).isBinary());
        Assert.assertFalse(new Tree.Node<>(2, new Tree.Node<>(3), null).isBinary());

        Assert.assertFalse(new Tree.Node<>(2, new Tree.Node<>(3), new Tree.Node<>(1)).isBinary());

        // multiple layers
        //         4
        //   (2    ,    5)
        // (1 , 3)   (6 , 4)
        Assert.assertFalse(new Tree.Node<>(4,
                new Tree.Node<>(2, new Tree.Node<>(1), new Tree.Node<>(3)),
                new Tree.Node<>(5, new Tree.Node<>(6), new Tree.Node<>(4))).isBinary());

    }

    @Test
    public void testTraverse() {
        //         4
        //   (2    ,    6)
        // (1 , 3)   (5 , 7)
        Assert.assertEquals(new Tree.Node<>(4,
                new Tree.Node<>(2, new Tree.Node<>(1), new Tree.Node<>(3)),
                new Tree.Node<>(6, new Tree.Node<>(5), new Tree.Node<>(7))).traverse(), Arrays.asList(1,2,3,4,5,6,7));
    }

    @Test
    public void testTraverseAndCompare() {
        Tree.Node<Integer> tree = new Tree.Node<>(2, new Tree.Node<>(1), new Tree.Node<>(3));

        Assert.assertTrue(tree.allNodesBiggerThan(0));
        Assert.assertTrue(tree.allNodesSmallerThan(4));

        Assert.assertFalse(tree.allNodesBiggerThan(4));
        Assert.assertFalse(tree.allNodesSmallerThan(0));
    }
}
