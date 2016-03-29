package com.arr;

import org.junit.Test;

public class SumOfS {
	// 和为s的两个数
	// 一前一后两个指针,和大了的时候后指针向前移动,和小了,前指针向后移动
	public int[] sumOfS(int[] nums, int s) {
		if (nums == null || nums.length < 2) {
			return new int[2];
		}

		int[] result = new int[2];
		int start = 0;
		int end = nums.length - 1;
		int sum = 0;
		while (start < end) {
			sum = nums[start] + nums[end];
			if (sum == s) {
				System.out.println(nums[start]);
				System.out.println(nums[end]);
				return null;
			} else if (sum > s) {
				--end;
			} else {
				++start;
			}
		}

		return result;
	}

	// 和为s的连续整数系列
	public void sumOfSSequence(int s) {
		if (s < 3) {
			return;
		}

		int lIndex = 1;
		int rIndex = 2;
		int sum = 3;
		while (lIndex <= s / 2 && rIndex <= (s + 1) / 2) {
			if (sum == s) {
				System.out.println(lIndex + "-" + rIndex);
				++rIndex;
				sum += rIndex;
			} else if (sum > s) {
				sum -= lIndex;
				++lIndex;
			} else {
				++rIndex;
				sum += rIndex;
			}
		}
	}

	@Test
	public void test_sumOfS() {
		int[] nums = { 1, 2, 4, 7, 11, 15 };
		sumOfS(nums, 15);
	}

	@Test
	public void test_sumOfSSequence() {
		sumOfSSequence(15);
	}
}
