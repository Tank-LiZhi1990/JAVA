package Sword.src.com.list;

import Sword.src.com.node.ListNode;
import org.junit.Test;

import com.node.ListNode;

public class LastKNode {
	// 倒数第k个元素
	public ListNode lastKNode(ListNode head, int k) {
		// k=0时 很重要
		if (head == null || k <= 0) {
			return null;
		}

		/*
		 * 后一个指针在前一个指针的倒数第K个位置,同时移动
		 */
		ListNode pNodeAhead = head;

		int i = k - 1;
		while (i > 0) {
			if (pNodeAhead.next != null) {
				pNodeAhead = pNodeAhead.next;
			} else {
				return null;
			}
			--i;
		}

		ListNode pNodeBehind = head;
		while (pNodeAhead.next != null) {
			pNodeAhead = pNodeAhead.next;
			pNodeBehind = pNodeBehind.next;
		}

		return pNodeBehind;
	}

	@Test
	public void test_lastKNode() {
		ListNode head = new ListNode(0);
		ListNode pHead = head;
		for (int i = 1; i < 10; ++i) {
			ListNode nextNode = new ListNode(i);
			nextNode.next = null;
			pHead.next = nextNode;
			pHead = pHead.next;
		}

		ListNode result = lastKNode(head, 4);
		if (result != null) {
			System.out.println(result.value);
		} else {
			System.out.println(result);
		}
		result = lastKNode(null, 4);
		if (result != null) {
			System.out.println(result.value);
		} else {
			System.out.println(result);
		}
		result = lastKNode(head, 0);
		if (result != null) {
			System.out.println(result.value);
		} else {
			System.out.println(result);
		}
		result = lastKNode(head, -1);
		if (result != null) {
			System.out.println(result.value);
		} else {
			System.out.println(result);
		}
		result = lastKNode(head, 14);
		if (result != null) {
			System.out.println(result.value);
		} else {
			System.out.println(result);
		}

	}
}
