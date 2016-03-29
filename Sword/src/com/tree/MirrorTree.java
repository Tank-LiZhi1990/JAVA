package com.tree;

import org.junit.Test;

import com.node.TreeNode;

public class MirrorTree {
	// 求二叉树的镜面,递归翻转子树
	public void mirrorTree(TreeNode root) {
		if (root == null || (root.leftNode == null && root.rightNode == null)) {
			return;
		}

		TreeNode left = root.leftNode;
		TreeNode right = root.rightNode;

		TreeNode temp = root.leftNode;
		root.leftNode = root.rightNode;
		root.rightNode = temp;

		mirrorTree(left);
		mirrorTree(right);
	}

	@Test
	public void test_mirrorTree() {
		TreeNode root = new TreeNode(0);
		root.leftNode = new TreeNode(1);
		root.rightNode = new TreeNode(2);

		mirrorTree(root);

		mirrorTree(null);

		mirrorTree(new TreeNode(0));

	}
}
