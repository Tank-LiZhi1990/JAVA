package com.arr;

import org.junit.Test;

public class SequencePoker {
	// 随机抽五张牌判断顺子

	private static final int NUM_LENGTH = 5;

	public boolean isContinuous(int[] nums) {

		if (nums == null || nums.length != NUM_LENGTH) {
			return false;
		}

		sort(nums);

		int countOf0 = 0;
		int i = 0;
		int gap = 0;
		for (i = 0; i < nums.length; ++i) {
			if (nums[i] == 0) {
				++countOf0;
			} else {
				if (i + 1 < nums.length) {
					if (nums[i + 1] == nums[i]) {
						return false;
					} else {
						gap += nums[i + 1] - nums[i] - 1;
					}
				}
			}
		}

		if (gap > countOf0) {
			return false;
		}

		return true;
	}

	private void sort(int[] nums) {
		for (int i = 0; i < nums.length - 1; ++i) {
			for (int j = 0; j < nums.length - i - 1; ++j) {
				if (nums[j + 1] < nums[j]) {
					swap(nums, j + 1, j);
				}
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	@Test
	public void test_isContinuous() {
		int[] nums = { 3, 6, 5, 7, 4 };
		System.out.println(isContinuous(nums));
	}
}
