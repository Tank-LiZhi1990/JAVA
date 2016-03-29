package com.list;

import org.junit.Test;

import com.node.ListNode;

public class MergeTwoPOrdered {
	public ListNode mergeTwoOrdered(ListNode list1, ListNode list2) {

		if (list1 == null) {
			return list2;
		}

		if (list2 == null) {
			return list1;
		}

		ListNode newHead = null;
		ListNode next1 = list1;
		ListNode next2 = list2;

		if (list1.value < list2.value) {
			newHead = list1;
			next1 = list1.next;
		} else {
			newHead = list2;
			next2 = list2.next;
		}

		ListNode next = newHead;
		while (next1 != null && next2 != null) {
			if (next1.value < next2.value) {
				next.next = next1;
				next1 = next1.next;
			} else {
				next.next = next2;
				next2 = next2.next;
			}
			next = next.next;
		}

		while (next1 != null) {
			next.next = next1;
			next1 = next1.next;
		}

		while (next2 != null) {
			next.next = next2;
			next2 = next2.next;
		}

		return newHead;
	}

	public ListNode mergerRecursively(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}

		if (list2 == null) {
			return list1;
		}

		ListNode mergedHead = null;
		if (list1.value < list2.value) {
			mergedHead = list1;
			mergedHead.next = mergerRecursively(list1.next, list2);
		} else {
			mergedHead = list2;
			mergedHead.next = mergerRecursively(list1, list2.next);
		}

		return mergedHead;
	}

	@Test
	public void test_mergeTwoOrdered() {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(0);

		ListNode p1 = list1;
		ListNode p2 = list2;

		for (int i = 2; i < 10; ++i) {
			ListNode pNode = new ListNode(i);
			if ((i & 0x1) == 1) {
				p1.next = pNode;
				p1 = p1.next;
			} else {
				p2.next = pNode;
				p2 = p2.next;
			}
		}

		printList(mergeTwoOrdered(list1, list2));
		printList(mergeTwoOrdered(list1, null));
		printList(mergeTwoOrdered(null, list2));
		printList(mergeTwoOrdered(null, null));

		list1 = new ListNode(1);
		list2 = new ListNode(0);

		printList(mergeTwoOrdered(list1, list2));
		printList(mergeTwoOrdered(list1, null));
		printList(mergeTwoOrdered(null, list2));
		printList(mergeTwoOrdered(null, null));
	}

	@Test
	public void test_mergerRecursively() {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(0);

		ListNode p1 = list1;
		ListNode p2 = list2;

		for (int i = 2; i < 10; ++i) {
			ListNode pNode = new ListNode(i);
			if ((i & 0x1) == 1) {
				p1.next = pNode;
				p1 = p1.next;
			} else {
				p2.next = pNode;
				p2 = p2.next;
			}
		}

		// printList(mergerRecursively(list1, list2));
		// printList(mergerRecursively(list1, null));
		// printList(mergerRecursively(null, null));
		printList(mergerRecursively(null, list2));

		list1 = new ListNode(1);
		list2 = new ListNode(0);

		// printList(mergerRecursively(list1, list2));
		// printList(mergerRecursively(list1, null));
		// printList(mergerRecursively(null, null));
		printList(mergerRecursively(null, list2));
	}

	private void printList(ListNode result) {
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}

		System.out.println();
	}
}
