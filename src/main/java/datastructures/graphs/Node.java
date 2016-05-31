package datastructures.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private final String name;
	private boolean visited;
	private List<Node> children = new ArrayList<>();

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void addChild(Node child) {
		children.add(child);
	}

	@Override
	public String toString() {
		return String.format("Node[%s/%s]", name, visited);
	}
}
