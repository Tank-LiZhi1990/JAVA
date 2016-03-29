package com.arr;

import org.junit.Test;

public class UglyNumber {
	// 以2,3,5为全部约数的数
	public int uglyNumber(int n) {
		if (n < 1) {
			return 0;
		}

		int[] uglyNums = new int[n];

		int p2 = 0;
		int p3 = 0;
		int p5 = 0;

		int nextIndex = 1;
		int curMin = 1;

		uglyNums[0] = 1;
		while (nextIndex < n) {
			curMin = min3(uglyNums[p2] * 2, uglyNums[p3] * 3, uglyNums[p5] * 5);
			uglyNums[nextIndex] = curMin;
			while (uglyNums[p2] * 2 <= uglyNums[nextIndex]) {
				++p2;
			}
			while (uglyNums[p3] * 3 <= uglyNums[nextIndex]) {
				++p3;
			}
			while (uglyNums[p5] * 5 <= uglyNums[nextIndex]) {
				++p5;
			}

			++nextIndex;
		}
		return uglyNums[nextIndex - 1];
	}

	private int min3(int i, int j, int k) {
		int min = (i < j) ? i : j;
		min = (min < k) ? min : k;
		return min;
	}

	@Test
	public void test_uglyNumber() {
		int n1 = 1;
		System.out.println(uglyNumber(n1));

		int n2 = 0;
		System.out.println(uglyNumber(n2));

		int n3 = 3;
		System.out.println(uglyNumber(n3));

		int n4 = 4;
		System.out.println(uglyNumber(n4));

		int n5 = 7;
		System.out.println(uglyNumber(n5));

		int n6 = 6;
		System.out.println(uglyNumber(n6));

		int n7 = 1500;
		System.out.println(uglyNumber(n7));

		// 2^31-1
		System.out.println(Integer.MAX_VALUE);

	}
}
