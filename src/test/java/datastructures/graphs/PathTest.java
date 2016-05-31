package datastructures.graphs;

import org.testng.Assert;
import org.testng.annotations.Test;

import datastructures.graphs.Path;

public class PathTest {
	@Test
	public void testToString() {
		Assert.assertEquals(new Path("A", "B", "C").toString(), "[A, B, C]");
	}
}
