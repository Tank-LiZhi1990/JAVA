package com.arr;

import org.junit.Test;

public class MaxSubArray {

	// 子数组的最大和
	public Integer maxSubArray(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}

		int sum = nums[0];
		int maxSum = sum;
		for (int i = 1; i < nums.length; ++i) {
			// 如果加上下一个数比原来的和还要小,则下一个数就是当前最大的和
			if (sum + nums[i] < nums[i]) {
				sum = nums[i];
				if (sum > maxSum) {
					maxSum = sum;
				}
				continue;
			}

			// 如果加上下一个数比当前和小且当前和比记录的最大和大,则更新和
			if (sum + nums[i] < sum && sum > maxSum) {
				maxSum = sum;
			}
			// 继续累加
			sum += nums[i];
		}
		
		return maxSum;
	}

	@Test
	public void test_maxSubArray() {
		int[] nums = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(maxSubArray(nums));

		int[] nums1 = { 1, -2, -13 };
		System.out.println(maxSubArray(nums1));

	}
}
