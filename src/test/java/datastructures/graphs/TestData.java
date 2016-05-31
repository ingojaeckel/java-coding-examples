package datastructures.graphs;

import datastructures.graphs.Matrix;

public class TestData {
	public Matrix getMatrix() {
		Matrix matrix = new Matrix(5);
		// "A"
		matrix.set(1, 0, true);
		matrix.set(2, 0, true);

		// "B"
		matrix.set(0, 1, true);
		matrix.set(2, 1, true);
		matrix.set(3, 1, true);
		matrix.set(4, 1, true);

		// "C"
		matrix.set(0, 2, true);
		matrix.set(1, 2, true);
		matrix.set(3, 2, true);

		// "D"
		matrix.set(1, 3, true);
		matrix.set(2, 3, true);
		matrix.set(4, 3, true);

		// "E"
		matrix.set(1, 4, true);
		matrix.set(3, 4, true);
		return matrix;
	}
}
