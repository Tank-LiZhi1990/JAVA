package com;

import org.junit.Test;

public class ADDNOAMMD {

	// 不用加减乘除做加法
	// 通过位运算,分三步,第一步:相加不进位(异或的结果一致),第二步:求进位(与),第三步:第一第二步结果重复第一步

	// 正数,负数都适用
	public int add(int a, int b) {

		int sum, carry;
		do {
			sum = a ^ b;
			carry = (a & b) << 1;

			a = sum;
			b = carry;
		} while (b != 0);

		return a;
	}

	public void swap(int[] nums, int i, int j) {
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	public void swap2(int[] nums, int i, int j) {
		nums[i] = nums[i] + nums[j];
		nums[j] = nums[i] - nums[j];
		nums[i] = nums[i] - nums[j];
	}

	@Test
	public void test_add() {
		System.out.println(add(10, -9));
		System.out.println(add(10, 9));
		System.out.println(add(-1, -1));

	}
}
