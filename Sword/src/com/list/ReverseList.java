package com.list;

import org.junit.Test;

import com.node.ListNode;

public class ReverseList {
	// 翻转链表On时间
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		// 一个节点
		if (head.next == null) {
			return head;
		}

		// 至少有两个节点时
		ListNode nextNode = null;
		ListNode newHead = head;

		// 记录头结点的下一个节点,让该节点指向头结点,头结点指向下下个节点,直到头结点指向空
		while (head.next != null) {
			nextNode = head.next;
			head.next = nextNode.next;
			nextNode.next = newHead;
			newHead = nextNode;
		}

		return newHead;
	}

	public void printList(ListNode head) {
		if (head == null) {
			System.out.println(head);
			return;
		}

		ListNode pNode = head;
		while (pNode != null) {
			System.out.print(pNode.value + " ");
			pNode = pNode.next;
		}
		System.out.println();
	}

	@Test
	public void test_reverseList() {
		ListNode head = new ListNode(0);
		ListNode pHead = head;
		for (int i = 1; i < 10; ++i) {
			ListNode nextNode = new ListNode(i);
			pHead.next = nextNode;
			pHead = pHead.next;
		}

		reverseList(head);
		printList(pHead);

		reverseList(null);
		printList(null);

		reverseList(new ListNode(0));
		printList(new ListNode(0));
	}

	// 递归,找到最后一个节点后只返回最后一个节点
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode result = reverseList(head.next);
		head.next.next = head;
		head.next = null;

		return result;
	}

	@Test
	public void test_reverseList2() {
		ListNode head = new ListNode(0);
		ListNode pHead = head;
		for (int i = 1; i < 10; ++i) {
			ListNode nextNode = new ListNode(i);
			pHead.next = nextNode;
			pHead = pHead.next;
		}

		pHead = reverseList2(head);
		printList(pHead);

		pHead = reverseList2(null);
		printList(null);

		pHead = reverseList2(new ListNode(0));
		printList(new ListNode(0));
	}
}
