package com.list;

import java.util.Stack;

import org.junit.Test;

import com.node.ListNode;

public class OperateListNode {

	public static void main(String[] args) {

		ListNode head = new ListNode(0);

		ListNode pNode = head;
		for (int i = 1; i < 10; i++) {
			ListNode aNode = new ListNode(i);
			pNode.next = aNode;
			pNode = pNode.next;
		}
	}

	@Test
	public void test_insertToTail() {
		ListNode head = new ListNode(0);

		ListNode pNode = head;
		for (int i = 1; i < 10; i++) {
			ListNode aNode = new ListNode(i);
			pNode.next = aNode;
			pNode = pNode.next;
		}
		insertToTail(head, 11);
		insertToTail(null, 1);
		insertToTail(new ListNode(0), 1);
	}

	public void insertToTail(ListNode head, int mValue) {
		ListNode mNode = new ListNode(mValue);

		if (head == null) {
			head = mNode;
		} else {
			ListNode pNode = head;
			while (pNode.next != null) {
				pNode = pNode.next;
			}

			if (pNode != null) {
				pNode.next = mNode;
			}
		}
	}

	@Test
	public void test_deleteNode() {
		ListNode head = new ListNode(0);

		ListNode pNode = head;
		for (int i = 1; i < 10; i++) {
			ListNode aNode = new ListNode(i);
			pNode.next = aNode;
			pNode = pNode.next;
		}

		deleteNode(head, 0);
		deleteNode(head, 5);
		deleteNode(head, 9);
		deleteNode(head, -1);
	}

	public void deleteNode(ListNode head, int mValue) {
		ListNode toBeDelete = null;
		if (head != null) {
			if (head.value == mValue) {
				toBeDelete = head;
				head = head.next;
				toBeDelete.next = null;
			} else {
				ListNode pNode = head;
				while (pNode.next != null && pNode.next.value != mValue) {
					pNode = pNode.next;
				}
				if (pNode.next != null && pNode.next.value == mValue) {
					toBeDelete = pNode.next;
					pNode.next = pNode.next.next;
					toBeDelete.next = null;
				}
			}
		}
		// 函数结束后会被回收
	}

	@Test
	public void test_printFromTail() {
		ListNode head = new ListNode(0);

		ListNode pNode = head;
		for (int i = 1; i < 10; i++) {
			ListNode aNode = new ListNode(i);
			pNode.next = aNode;
			pNode = pNode.next;
		}

		printFromTail(head);
		printFromTail(null);
		
		printFromTail2(head);
		printFromTail2(null);
	}

	public void printFromTail(ListNode head) {
		Stack<ListNode> nodes = new Stack<>();
		ListNode pNode = head;
		while (pNode != null) {
			nodes.push(pNode);
			pNode = pNode.next;
		}

		while (!nodes.isEmpty()) {
			ListNode aNode = nodes.pop();
			System.out.print(aNode.value + " ");
		}
	}

	public void printFromTail2(ListNode head) {
		if (head != null) {
			printFromTail2(head.next);
			System.out.print(head.value + " ");
		}
	}
}
