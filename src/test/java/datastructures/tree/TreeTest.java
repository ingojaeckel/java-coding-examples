package datastructures.tree;

import datastructures.trees.Tree;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
    }
}
