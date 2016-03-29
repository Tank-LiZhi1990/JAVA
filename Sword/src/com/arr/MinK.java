package com.arr;

import org.junit.Test;

public class MinK {
	// 求最小的K个数,利用快排的分割,找到第K个位置,左侧的就是最小的K个数,前提是可以变动数组的内容
	public void minK(int[] nums, int k) {
		if (nums == null || k <= 0 || nums.length < k) {
			return;
		}

		int start = 0;
		int end = nums.length - 1;

		int mid = partition(nums, start, end);
		while (mid != k) {
			if (mid < k) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = partition(nums, start, end);
		}

		for (int i = 0; i < k; ++i) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	private int partition(int[] nums, int start, int end) {
		int pos = start;
		int x = nums[start];
		while (start < end) {
			while (start < end && nums[end] >= x) {
				--end;
			}
			nums[pos] = nums[end];
			pos = end;
			while (start < end && nums[start] <= x) {
				++start;
			}
			nums[pos] = nums[start];
			pos = start;
		}
		nums[pos] = x;
		return pos;
	}

	@Test
	public void test_minK() {
		int[] nums = { 4, 5, 1, 4, 6, 8, 9, 0 };
		minK(nums, 4);
	}
}
