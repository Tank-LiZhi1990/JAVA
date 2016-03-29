package com.list;

import java.util.LinkedList;

import org.junit.Test;

import com.node.ListNode;

public class JosphCircle {
	// 约瑟夫环
	public void josphCircle(int n, int m) {

		if (n <= 0 || m <= 0) {
			return;
		}

		ListNode head = new ListNode(0);
		ListNode pHead = head;
		for (int i = 1; i < n; ++i) {
			ListNode mNode = new ListNode(i);
			pHead.next = mNode;
			pHead = pHead.next;
		}

		pHead.next = head;
		ListNode pre = pHead;
		pHead = head;

		int count = 1;
		while (pHead.next != pHead) {
			if (count < m) {
				++count;
				pHead = pHead.next;
				pre = pre.next;
			} else {
				pre.next = pHead.next;
				pHead.next = null;
				// System.out.print(pHead.value + " ");
				pHead = pre.next;
				count = 1;
			}
		}
		System.out.print(pHead.value);
	}

	@Test
	public void test_josphCircle() {
		int n = 5;
		int m = 3;
		josphCircle(n, m);
	}

	public void josphCircle1(int n, int m) {

		if (n <= 0 || m <= 0) {
			return;
		}

		LinkedList<Integer> list = new LinkedList<>();
		for (int i = n - 1; i >= 0; --i) {
			list.push(i);
		}

		int current = -1;
		while (list.size() > 1) {
			for (int i = 0; i < m; ++i) {
				++current;
				if (current == list.size()) {
					current = 0;
				}
			}
			System.out.println(list.remove(current));
			--current;
			if (current == 0) {
				current = list.size() - 1;
			}
		}
		System.out.println(list.get(0));
	}

	@Test
	public void test_josphCircle1() {
		int n = 5;
		int m = 3;
		josphCircle1(n, m);
	}

	// 第一个去掉的数是(m-1)%n
	// f(n,m) = f'(n-1,m)
	// 做映射成顺序形式,f'(n-1,m)=(f(n-1,m)+k+1)%n,k=(m-1)%n,
	// f(n,m)=f'(n-1,m)=[f(n-1,m)+m]%n,n>1;0,n=1;
	public void josphCircle2(int n, int m) {

		if (n <= 0 || m <= 0) {
			return;
		}
		int last = 0;
		for (int i = 2; i <= n; ++i) {
			last = (last + m) % i;
			// last = (last + (m - 1) % i + 1) % i;
		}

		System.out.println(last);
	}

	@Test
	public void test_josphCircle2() {
		int n = 4000;
		int m = 3;
		josphCircle2(n, m);
	}
}
