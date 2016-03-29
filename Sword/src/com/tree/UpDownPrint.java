package com.tree;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.junit.Test;

import com.node.TreeNode;

public class UpDownPrint {
	// 广度优先遍历二叉树,使用队列
	public void upDownPrint(TreeNode root) {
		if (root == null) {
			return;
		}

		// 将根节点加入队列
		Queue<TreeNode> queue = new ConcurrentLinkedQueue<>();
		queue.offer(root);

		printRecursively(queue);
	}

	private void printRecursively(Queue<TreeNode> queue) {
		if (queue.isEmpty()) {
			return;
		}
		// 输出当前节点的值
		TreeNode root = queue.poll();
		System.out.println(root.value);

		// 将当前节点的左子树加入到队列中
		if (root.leftNode != null) {
			queue.offer(root.leftNode);
		}

		// 将当前节点的右子树加入到队列中
		if (root.rightNode != null) {
			queue.offer(root.rightNode);
		}

		// 递归输出队列中剩余的节点
		printRecursively(queue);
	}

	@Test
	public void test_upDownPrint() {
		int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		TreeNode root = new ConstructTree().constructTree(preOrder, inOrder);

		upDownPrint(root);
	}
}
