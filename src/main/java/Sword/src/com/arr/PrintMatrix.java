package Sword.src.com.arr;

import org.junit.Test;

public class PrintMatrix {

	// 旋转式输出矩阵
	public void printMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}
		int height = matrix.length;
		int width = matrix[0].length;

		int start = 0;

		// 每次打印起始位置都是(i,i),i*2<=min(height,width),
		while (2 * start < width && 2 * start < height) {
			printPreCircle(matrix, start, width, height);
			++start;
		}
	}

	private void printPreCircle(int[][] matrix, int start, int width, int height) {

		// 位置而不是长度
		int endX = width - start - 1;
		int endY = height - start - 1;

		// right,只有一个节点时相等
		if (endX >= start) {
			for (int i = start; i <= endX; ++i) {
				System.out.print(matrix[start][i] + " ");
			}
		}

		// down
		if (endY > start) {
			for (int i = start + 1; i <= endY; ++i) {
				System.out.print(matrix[i][endX] + " ");
			}
		}

		// left
		if (endX > start && endY > start) {
			for (int i = endX - 1; i >= start; --i) {
				System.out.print(matrix[endY][i] + " ");
			}
		}

		// up,如果需要向上,需要左侧至少三个 节点
		if (endX > start && endY - 1 > start) {
			for (int i = endY - 1; i > start; --i) {
				System.out.print(matrix[i][start] + " ");
			}
		}
	}

	@Test
	public void test_printMatrix() {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printMatrix(matrix);
		System.out.println();

		int[][] m1 = { { 1 } };
		printMatrix(m1);
		System.out.println();

		int[][] m2 = { { 1, 2, 3 } };
		printMatrix(m2);
		System.out.println();

		int[][] m3 = { { 1 }, { 2 }, { 3 } };
		printMatrix(m3);
		System.out.println();

	}
}
