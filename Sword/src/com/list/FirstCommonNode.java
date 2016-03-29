package com.list;

import java.util.Stack;

import com.node.ListNode;

public class FirstCommonNode {

	// 两个链表的第一个公共节点
	/*
	 * 第一种思路:用两个辅助栈,倒序比较最后一个相同的节点O(m+n),空间复杂度O(m+n)
	 * 
	 * 第二种思路:先得到两个链表的长度,再让长的链表走几步到达与短链表相同长度后同时移动O(m+n)
	 */

	// 1
	public ListNode firstCommonNode(ListNode h1, ListNode h2) {

		if (h1 == null || h2 == null) {
			return null;
		}
		if (h1 == h2) {
			return h1;
		}

		Stack<ListNode> s1 = new Stack<>();
		Stack<ListNode> s2 = new Stack<>();

		// 先将两个链表都入栈
		ListNode pNode = h1;
		while (pNode != null) {
			s1.push(pNode);
			pNode = pNode.next;
		}

		pNode = h2;
		while (pNode != null) {
			s1.push(pNode);
			pNode = pNode.next;
		}

		// 倒序比较,找到最后一个相同的节点
		ListNode common = null;
		while (!s1.isEmpty() && !s1.isEmpty() && s1.peek() == s1.peek()) {
			common = s1.peek();
			s1.pop();
			s2.pop();
		}

		return common;
	}

	// 2
	public ListNode firstCommonNode2(ListNode h1, ListNode h2) {

		if (h1 == null || h2 == null) {
			return null;
		}

		if (h1 == h2) {
			return h1;
		}

		// 计算两个链表的长度
		int len1 = 0;
		int len2 = 0;
		ListNode pNode = h1;
		while (pNode != null) {
			++len1;
		}

		pNode = h2;
		while (pNode != null) {
			++len2;
		}

		// 长的先走diff步
		ListNode p1 = h1;
		ListNode p2 = h2;
		int diff = 0;
		if (len1 > len2) {
			diff = len1 - len2;
			while (diff > 0) {
				p1 = p1.next;
				--diff;
			}
		} else {
			diff = len2 - len1;
			while (diff > 0) {
				p2 = p2.next;
				--diff;
			}
		}

		// 寻找共同节点
		while (p1.next != null && p2.next != null && p1.next != p2.next) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1.next;
	}
}
