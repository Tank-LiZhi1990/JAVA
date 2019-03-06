package Sword.src.com.tree;

import com.node.TreeNode;

public class ChildTree {
	// 找到相同节点后再判断是不是子树
	public boolean isChildTree(TreeNode tree1, TreeNode tree2) {

		boolean result = false;
		if (tree1 != null && tree2 != null) {
			if (tree1.value == tree2.value) {
				result = compare(tree1, tree2);

				if (!result) {
					result = isChildTree(tree1.leftNode, tree2);
				}

				if (!result) {
					result = isChildTree(tree1.rightNode, tree2);
				}
			}
		}

		return result;
	}

	private boolean compare(TreeNode tree1, TreeNode tree2) {

		if (tree2 == null) {
			return true;
		}

		if (tree1 == null) {
			return false;
		}

		if (tree1.value != tree2.value) {
			return false;
		}

		return compare(tree1.leftNode, tree2.leftNode) && compare(tree1.rightNode, tree2.rightNode);
	}
}
