package Sword.src.com.tree;

import org.junit.Test;

import com.node.TreeNode;

public class TreeDepth {
	public int treeDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int lDepth = treeDepth(root.leftNode);
		int rDepth = treeDepth(root.rightNode);

		return 1 + (lDepth > rDepth ? lDepth : rDepth);
	}

	@Test
	public void test_treeDepth() {
		TreeNode root = new TreeNode(10);
		TreeNode pNode = root;
		pNode.leftNode = new TreeNode(5);
		pNode.rightNode = new TreeNode(12);
		pNode = pNode.leftNode;
		pNode.leftNode = new TreeNode(4);
		pNode.rightNode = new TreeNode(7);

		System.out.println(treeDepth(root));
	}

	public boolean isBalanceTree(TreeNode root) {

		int[] depth = new int[1];

		return isBalanced(root, depth);
	}

	private boolean isBalanced(TreeNode root, int[] depth) {
		if (root == null) {
			depth[0] = 0;
			return true;
		}

		int[] left = new int[1];
		int[] right = new int[1];
		if (isBalanced(root.leftNode, left) && isBalanced(root.rightNode, right)) {
			int diff = left[0] - right[0];
			if (diff >= -1 && diff <= 1) {
				depth[0] = 1 + left[0] + right[0];
				return true;
			}
		}

		return false;
	}

	@Test
	public void test_isBalanceTree() {

		TreeNode root = new TreeNode(10);
		TreeNode pNode = root;
		pNode.leftNode = new TreeNode(5);
		pNode.rightNode = new TreeNode(12);
		pNode = pNode.leftNode;
		pNode.leftNode = new TreeNode(4);
		pNode.rightNode = new TreeNode(7);

		System.out.println(isBalanceTree(null));
		System.out.println(isBalanceTree(root));
		System.out.println(treeDepth(root));
	}

}
