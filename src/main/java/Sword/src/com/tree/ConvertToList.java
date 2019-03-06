package Sword.src.com.tree;

import org.junit.Test;

import com.node.TreeNode;

public class ConvertToList {
	// 将二叉排序树转换成有序双向链表
	public TreeNode convertToList(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode leftHead = null;
		TreeNode rightHead = null;

		// 找到左子树转换为双向链表的头结点
		if (root.leftNode != null) {
			leftHead = convertToList(root.leftNode);
		}

		// 找到右子树转换为双向链表的头结点
		if (root.rightNode != null) {
			rightHead = convertToList(root.rightNode);
		}

		if (leftHead != null) {
			// 找到最后一个节点,并与当前节点连接
			TreeNode lastNode = leftHead;
			while (lastNode.rightNode != null) {
				lastNode = lastNode.rightNode;
			}
			lastNode.rightNode = root;
			root.leftNode = lastNode;
		} else {
			// 左子树为空,当前节点就是头结点
			leftHead = root;
		}

		// 将当前节点与右子树的头结点连接
		if (rightHead != null) {
			root.rightNode = rightHead;
			rightHead.leftNode = root;
		}

		// 返回这颗子树转换成双向链表后的头结点,也就是左节点或者当前节点
		return leftHead;
	}

	@Test
	public void test_convertToList() {
		TreeNode root = new TreeNode(10);
		TreeNode pNode = root;
		pNode.leftNode = new TreeNode(5);
		pNode.rightNode = new TreeNode(12);
		pNode = pNode.leftNode;
		pNode.leftNode = new TreeNode(4);
		pNode.rightNode = new TreeNode(7);

		TreeNode nHead = convertToList(root);
		System.out.println(nHead);

		convertToList(null);
	}
}
