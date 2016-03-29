package com.arr;

import org.junit.Test;

public class MinInSpinCircle {

	/*
	 * 1.旋转数组的第一个数大于最后一个数,表示旋转过 2.旋转数组的第一个数小于最后一个数,表示未旋转过
	 * 3.旋转数组第一个数和最后一个一样,且和中间一个一样,无法判断
	 * 
	 */
	public int minInSpinCircle(int[] arrs) {
		if (arrs == null || arrs.length == 0) {
			return -1;
		}

		int length = arrs.length;
		if (arrs[0] < arrs[length - 1] || arrs.length == 1) {
			return 0;
		}

		int start = 0;
		int end = length - 1;
		while (end - start > 1) {
			int mid = (end + start) / 2;

			// 无法判断的情况
			if (arrs[start] == arrs[end] && arrs[start] == arrs[mid]) {
				return minInOrder(arrs);
			}

			// 中间的比左边大,最小数在右边
			if (arrs[mid] >= arrs[start]) {
				start = mid;
			} else if (arrs[mid] <= arrs[end]) {
				// 否则,最小数在左边
				end = mid;
			}
		}

		return end;
	}

	private int minInOrder(int[] arrs) {

		if (arrs == null || arrs.length == 1) {
			return 0;
		}

		int min = arrs[0];
		int index = 0;
		for (int i = 1; i < arrs.length; ++i) {
			if (arrs[i] < min) {
				index = i;
			}
		}
		return index;
	}

	@Test
	public void test_minInSpinCircle() {
		int[] nums = { 3, 4, 5, 1, 2, 3 };
		System.out.println(minInSpinCircle(nums));

		System.out.println(minInSpinCircle(null));

		int[] nums1 = { 1, 1, 1, 1, 1, 1, 0, 1 };
		System.out.println(minInSpinCircle(nums1));

		int[] nums2 = { 1 };
		System.out.println(minInSpinCircle(nums2));
	}
}
