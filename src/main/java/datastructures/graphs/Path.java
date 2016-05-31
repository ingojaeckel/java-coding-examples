package datastructures.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {
	private final List<String> points;

	public Path(List<String> points) {
		this.points = points;
	}

	public Path(String... points) {
		this.points = new ArrayList<>(Arrays.asList(points));
	}

	public List<String> getPoints() {
		return new ArrayList<>(points);
	}

	public Path add(String... additionalPoints) {
		Path newPath = new Path(new ArrayList<>(this.points));
		newPath.points.addAll(Arrays.asList(additionalPoints));
		return newPath;
	}

	public boolean contains(Node node) {
		return points.contains(node.getName());
	}

	public int indexOf(Node node) {
		return points.indexOf(node.getName());
	}

	@Override
	public String toString() {
		return points.toString();
	}
}
