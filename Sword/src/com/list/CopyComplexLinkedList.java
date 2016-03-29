package com.list;

import org.junit.Test;

public class CopyComplexLinkedList {
	// 复制复杂数组
	public ComplexListNode copyComplexLinkedList(ComplexListNode head) {
		if (head == null) {
			return null;
		}

		// 复制节点，插入到源节点后面
		ComplexListNode pNode = head;
		while (pNode != null) {
			ComplexListNode copiedNode = new ComplexListNode(pNode.value);
			copiedNode.next = pNode.next;
			pNode.next = copiedNode;
			pNode = copiedNode.next;
		}

		// 复制侧链接关系
		pNode = head;
		while (pNode != null) {
			if (pNode.sibling != null)
				pNode.next.sibling = pNode.sibling.next;
			pNode = pNode.next.next;
		}

		// 分离节点
		pNode = head;
		ComplexListNode nHead = pNode.next;
		ComplexListNode qNode = nHead;
		while (pNode != null) {
			pNode.next = qNode.next;
			pNode = pNode.next;

			if (pNode != null) {
				qNode = pNode.next;
			} else {
				break;
			}
		}

		return nHead;
	}

	private class ComplexListNode {
		int value = 0;
		ComplexListNode next = null;
		ComplexListNode sibling = null;

		public ComplexListNode(int val) {
			this.value = val;
		}
	}

	@Test
	public void test_copyComplexLinkedList() {
		ComplexListNode head = new ComplexListNode(0);
		ComplexListNode pNode = head;
		for (int i = 1; i < 10; ++i) {
			ComplexListNode nNode = new ComplexListNode(i);
			pNode.next = nNode;
			pNode = pNode.next;
		}

		printComplexNode(copyComplexLinkedList(head));
	}

	private void printComplexNode(ComplexListNode head) {
		ComplexListNode pNode = head;
		while (pNode != null) {
			System.out.print(pNode.value + " ");
			pNode = pNode.next;
		}
	}
}
