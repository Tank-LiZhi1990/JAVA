package com.tree;

import java.util.Stack;

import org.junit.Test;

import com.node.TreeNode;

public class CommonAncestor {

	// 最低公共祖先

	// 如果有指向父节点的指针,则直接按照:两个链表的第一个公共节点来做
	// 如果没有指向父节点的指针,两个栈,遍历到两个节点,然后让栈的大小一样,再同时弹出,看哪个相同
	// 或者新建两个链表,记录路径,然后从路径起点开始遍历,空间复杂度能有所降低,(list)
	// 如果是二叉搜索树,那么只要判断当前节点是否比一个大比另一个小,如果比两个都大,则在左节点寻找,否则在右节点寻找
	public TreeNode commonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {

		if (root == null) {
			// 异常情况
			return null;
		}
		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}

		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();

		findPosition(root, node1, stack1);
		findPosition(root, node2, stack2);

		if (stack1.size() > stack2.size()) {
			while (stack1.size() > stack2.size()) {
				stack1.pop();
			}
		} else if (stack2.size() > stack1.size()) {
			while (stack2.size() > stack1.size()) {
				stack2.pop();
			}
		}

		TreeNode result = null;
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.peek() != stack2.peek()) {
				stack1.pop();
				stack2.pop();
			} else {
				result = stack1.peek();
				break;
			}
		}
		return result;
	}

	private boolean findPosition(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
		if (root == null) {
			return false;
		}

		stack.push(root);
		if (root == node) {
			return true;
		}

		if (!findPosition(root.leftNode, node, stack) && !findPosition(root.rightNode, node, stack)) {
			stack.pop();
			return false;
		}

		return true;
	}

	@Test
	public void test_commonAncestor() {
		TreeNode root = new TreeNode(10);
		TreeNode pNode = root;
		pNode.leftNode = new TreeNode(5);
		pNode.rightNode = new TreeNode(12);

		TreeNode node1 = pNode.rightNode;

		pNode = pNode.leftNode;
		pNode.leftNode = new TreeNode(4);
		pNode.rightNode = new TreeNode(7);

		TreeNode node2 = pNode.leftNode;

		TreeNode ancestor = commonAncestor(root, node1, node2);
		System.out.println(ancestor.value);
	}
}
