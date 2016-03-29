package com.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.node.TreeNode;

public class FindPath {
	// 寻找节点和为sum的路径
	public void findPath(TreeNode root, int sum) {
		if (root == null) {
			return;
		}

		List<TreeNode> list = new ArrayList<>();
		// 只寻找以当前为根的路径
		findPathR(root, sum, list);

		// 遍历树，得到所有的路径，以每个节点为根
	}

	private void findPathR(TreeNode root, int sum, List<TreeNode> list) {
		if (root == null) {
			return;
		}

		list.add(root);

		// 已经找到,输出路径
		if (sum == root.value) {
			Iterator<TreeNode> it = list.iterator();
			while (it.hasNext()) {
				System.out.print(it.next().value + " ");
			}
			System.out.println();
		} else if (sum > root.value) {
			// 未找到,分别在左右子树上找路径
			findPathR(root.leftNode, sum - root.value, list);
			findPathR(root.rightNode, sum - root.value, list);
		}

		list.remove(root);
	}

	@Test
	public void test_findPath() {
		TreeNode root = new TreeNode(10);
		TreeNode pNode = root;
		pNode.leftNode = new TreeNode(5);
		pNode.rightNode = new TreeNode(12);
		pNode = pNode.leftNode;
		pNode.leftNode = new TreeNode(4);
		pNode.rightNode = new TreeNode(7);

		findPath(root, 22);

		findPath(pNode, 7);
		findPath(pNode, 4);
		findPath(null, 4);
		findPath(root, 20);
	}
}
