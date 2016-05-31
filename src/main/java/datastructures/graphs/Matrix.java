package datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class Matrix {
	private boolean[][] matrix;
	private final int nodeCount;

	public Matrix(int nodeCount) {
		this.nodeCount = nodeCount;
		this.matrix = new boolean[nodeCount][];
	}

	public void set(int x, int y, boolean value) {
		if (y > nodeCount - 1 || x > nodeCount - 1) {
			throw new IllegalArgumentException("coordinates must not be bigger than: " + (nodeCount - 1));
		}

		if (matrix[y] == null) {
			matrix[y] = new boolean[nodeCount];
		}
		matrix[y][x] = value;
	}

	public boolean isSet(int x, int y) {
		return matrix[y][x];
	}

	public List<Node> getNodes() {
		List<Node> nodes = new ArrayList<>(nodeCount);
		for (int i = 0; i < nodeCount; i++) {
			Node node = new Node(String.valueOf(i));
			nodes.add(node);
		}

		for (int y = 0; y < nodeCount; y++) {
			for (int x = 0; x < nodeCount; x++) {
				if (x == y) {
					continue;
				}
				if (matrix[y][x]) {
					Node child = nodes.get(x);
					nodes.get(y).addChild(child);
				}
			}
		}

		return nodes;
	}
}
