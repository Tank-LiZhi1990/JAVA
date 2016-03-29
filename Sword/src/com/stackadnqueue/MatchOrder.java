package com.stackadnqueue;

import java.util.Stack;

import org.junit.Test;

public class MatchOrder {
	// 判断栈输入输出系列的匹配
	public boolean matchStackOrder(int[] pushOrder, int[] popOrder) {
		if (pushOrder == null && popOrder == null) {
			return true;
		}

		if (pushOrder == null || popOrder == null) {
			return false;
		}

		if (pushOrder.length != popOrder.length) {
			return false;
		}

		int i = 0;

		Stack<Integer> pushStack = new Stack<>();
		pushStack.push(pushOrder[i]);
		++i;

		// 指定出序列的前面的值
		for (int k = 0; k < popOrder.length; ++k) {
			// 判断栈顶元素是否与该值相等
			while (pushStack.isEmpty() || popOrder[k] != pushStack.peek()) {
				if (i < pushOrder.length) {
					pushStack.push(pushOrder[i]);
					++i;
				} else {
					// 所有元素已入栈
					return false;
				}
			}
			// 相同则弹出,继续指定下一个出系列的值
			pushStack.pop();
		}

		// 栈为空,则匹配
		return pushStack.isEmpty();
	}

	@Test
	public void test_matchStackOrder() {
		int[] popOrder = { 4, 5, 3, 2, 1 };
		int[] pushOrder = { 1, 2, 3, 4, 5 };
		System.out.println(matchStackOrder(pushOrder, popOrder));

		int[] popOrder1 = { 4, 5, 2, 3, 1 };
		int[] pushOrder1 = { 1, 2, 3, 4, 5 };
		System.out.println(matchStackOrder(pushOrder1, popOrder1));

		int[] popOrder2 = { 4, 5, 2, 3, 1 };
		int[] pushOrder2 = { 1, 2, 3 };
		System.out.println(matchStackOrder(pushOrder2, popOrder2));

		int[] popOrder3 = null;
		int[] pushOrder3 = { 1, 2, 3, 4, 5 };
		System.out.println(matchStackOrder(pushOrder3, popOrder3));

		int[] popOrder4 = { 1, 2 };
		int[] pushOrder4 = { 2, 1 };
		System.out.println(matchStackOrder(pushOrder4, popOrder4));

	}
}
