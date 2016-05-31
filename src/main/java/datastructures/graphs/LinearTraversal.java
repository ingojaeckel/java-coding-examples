package datastructures.graphs;

import java.util.List;

public class LinearTraversal implements Traversable {

	@Override
	public Path traverse(List<Node> nodes) {
		Node firstNode = nodes.get(0);
		Path path = new Path(firstNode.getName());

		for (Node child : firstNode.getChildren()) {
			Path roundTripPath = traverse(child, path.add(child.getName()), firstNode, nodes.size() + 1);
			if (roundTripPath != null) {
				return roundTripPath;
			}
		}

		return null;
	}

	private Path traverse(Node currentNode, Path existingPath, Node targetNode, int targetPathLength) {
		if (existingPath.getPoints().size() == targetPathLength && currentNode.equals(targetNode)) {
			// looks like we found a path back to the target node.
			return existingPath;
		}

		for (Node child : currentNode.getChildren()) {
			if (!child.equals(targetNode) && existingPath.contains(child)) {
				continue;
			}

			Path path = traverse(child, existingPath.add(child.getName()), targetNode, targetPathLength);
			if (path != null) {
				return path;
			}
		}
		return null;
	}

}
