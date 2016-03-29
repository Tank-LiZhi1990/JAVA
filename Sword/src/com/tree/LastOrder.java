package com.tree;

import org.junit.Test;

public class LastOrder {
	// 判断数组是不是二叉搜索树的后序遍历
	public boolean isLastOrder(int[] order) {

		if (order == null || order.length == 0) {
			return false;
		}

		return checkRecursively(order, 0, order.length);
	}

	private boolean checkRecursively(int[] order, int start, int end) {

		// 找到后序遍历的根节点,最后一个节点
		int i = 0;
		int root = order[end - 1];
		// 找到比根节点大的第一个节点
		for (i = start; i < end - 1; ++i) {
			if (root < order[i]) {
				break;
			}
		}

		// 判断从第一个比根节点大的节点开始,后面的节点是否都比根节点大
		int j = i;
		for (j = i; j < end - 1; ++j) {
			if (root > order[j]) {
				return false;
			}
		}

		boolean result = true;
		// 存在左子树
		if (start < i)
			result = checkRecursively(order, start, i);

		// 存在右子树,且左子树是后序遍历
		if (i < end - 1 && result)
			// 判断右子树是否是后续遍历
			result = checkRecursively(order, i, end - 1);

		return result;
	}

	@Test
	public void test_isLastOrder() {
		int[] order = { 5, 7, 6, 9, 11, 10, 8 };
		System.out.println(isLastOrder(order));

		int[] order1 = { 1, 2, 3 };
		System.out.println(isLastOrder(order1));

		int[] order12 = { 3 };
		System.out.println(isLastOrder(order12));

		int[] order123 = { 7, 4, 6, 5 };
		System.out.println(isLastOrder(order123));

		System.out.println(isLastOrder(null));

	}

}
