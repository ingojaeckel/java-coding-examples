package datastructures.graphs;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import datastructures.graphs.LinearTraversal;
import datastructures.graphs.Matrix;
import datastructures.graphs.Node;
import datastructures.graphs.Path;

public class TraversalTest {
	@Test
	public void testTraversal() {
		Matrix matrix = new TestData().getMatrix();
		List<Node> nodes = matrix.getNodes();

		LinearTraversal traversal = new LinearTraversal();
		Path p = traversal.traverse(nodes);
		Assert.assertNotNull(p);
		Assert.assertEquals(p.toString(), "[0, 1, 4, 3, 2, 0]");
	}
}
