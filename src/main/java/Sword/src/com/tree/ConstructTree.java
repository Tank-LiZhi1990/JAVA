package Sword.src.com.tree;

import org.junit.Test;

import com.node.TreeNode;

public class ConstructTree {
	// 根据中序和先序还原二叉树
	public TreeNode constructTree(int[] preOrder, int[] inOrder) {
		if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0) {
			return null;
		}

		return constructChild(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
	}

	private TreeNode constructChild(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
		TreeNode root = new TreeNode(preOrder[preStart]);

		int rootPosIn = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (inOrder[i] == preOrder[preStart]) {
				rootPosIn = i;
				break;
			}
		}
		if (rootPosIn == -1) {
			throw new IllegalArgumentException("Invalid Input.");
		}

		if (rootPosIn > inStart) {
			root.leftNode = constructChild(preOrder, inOrder, preStart + 1, rootPosIn - inStart + preStart, inStart,
					rootPosIn - 1);
		}
		if (rootPosIn < inEnd) {
			root.rightNode = constructChild(preOrder, inOrder, preStart + rootPosIn - inStart + 1, preEnd,
					rootPosIn + 1, inEnd);
		}

		return root;
	}

	@Test
	public void test_constructTree() {
		int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		constructTree(preOrder, inOrder);
		constructTree(null, null);
		constructTree(preOrder, null);
		constructTree(null, inOrder);

		int[] preOrder2 = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder2 = { 4, 7, 9, 1, 5, 3, 8, 6 };
		constructTree(preOrder2, inOrder2);

		int[] preOrder3 = { 1, 2, 3, 4, 5 };
		int[] inOrder3 = { 5, 4, 3, 2, 1 };
		constructTree(preOrder3, inOrder3);
	}
}
