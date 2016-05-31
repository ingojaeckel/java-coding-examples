package datastructures.graphs;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import datastructures.graphs.Matrix;
import datastructures.graphs.Node;

public class MatrixTest {
	@Test
	public void getNodesTest() {
		Matrix m = new TestData().getMatrix();

		Assert.assertTrue(m.isSet(1, 0));
		Assert.assertFalse(m.isSet(3, 0));

		List<Node> nodes = m.getNodes();
		Assert.assertEquals(nodes.size(), 5);

		Assert.assertEquals(nodes.get(0).getChildren().size(), 2);
		Assert.assertEquals(nodes.get(1).getChildren().size(), 4);
		Assert.assertEquals(nodes.get(2).getChildren().size(), 3);
		Assert.assertEquals(nodes.get(3).getChildren().size(), 3);
		Assert.assertEquals(nodes.get(4).getChildren().size(), 2);

		Node node1 = nodes.get(0).getChildren().get(1);
		Node node2 = nodes.get(1).getChildren().get(1);
		Node node3 = nodes.get(2);
		Node node4 = nodes.get(3).getChildren().get(1);

		Assert.assertEquals(node1, node2);
		Assert.assertEquals(node2, node3);
		Assert.assertEquals(node3, node4);

		// All children within a node are different
		for (Node node : nodes) {
			List<Node> children = node.getChildren();

			for (int i = 0; i < children.size() - 1; i++) {
				Assert.assertNotEquals(children.get(i), children.get(i + 1));
			}
		}
	}
}
