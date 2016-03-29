package com.arr;

import org.junit.Test;

public class MinOrder {
	// 最小系列组合
	public String minOrder(int[] nums) {

		if (nums == null || nums.length == 0) {
			return null;
		}

		String[] numStr = new String[nums.length];
		// String[] minNum = new String[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			numStr[i] = String.valueOf(nums[i]);
			// minNum[i] = "";
		}

		String minNum = findMinOrder(numStr, 0, "");

		return minNum;
	}

	private String findMinOrder(String[] numStr, int start, String minNum) {
		if (start >= numStr.length) {
			String cur = "";
			for (int i = 0; i < numStr.length; ++i) {
				cur += numStr[i];
			}

			if (minNum == "" || cur.compareTo(minNum) < 0) {
				minNum = cur;
			}
		} else {
			for (int i = start; i < numStr.length; ++i) {
				String tmp = numStr[i];
				numStr[i] = numStr[start];
				numStr[start] = tmp;

				minNum = findMinOrder(numStr, start + 1, minNum);

				tmp = numStr[i];
				numStr[i] = numStr[start];
				numStr[start] = tmp;
			}
		}

		return minNum;
	}

	@Test
	public void test_minOrder() {
		// 不能有0在里面,否则会出现以0开头的数
		int[] nums = { 2, 123, 21 };
		System.out.println(minOrder(nums));
		int[] nums1 = { 21, 123, 21 };
		System.out.println(minOrder(nums1));
		int[] nums2 = { 2 };
		System.out.println(minOrder(nums2));
		int[] nums3 = { 2, 12 };
		System.out.println(minOrder(nums3));
	}

	// mn > nm时交换,快速排序
	public String minOrder2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		String[] numStr = new String[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			numStr[i] = String.valueOf(nums[i]);
		}

		quickSort(numStr, 0, numStr.length - 1);

		StringBuilder str = new StringBuilder();
		for (int i = 0; i < numStr.length; ++i) {
			str.append(numStr[i]);
		}
		return str.toString();
	}

	private void quickSort(String[] numStr, int start, int end) {

		int mid = partition(numStr, start, end);

		if (mid > start) {
			quickSort(numStr, start, mid - 1);
		}

		if (mid < end) {
			quickSort(numStr, mid + 1, end);
		}
	}

	// 一种交换,一种赋值,别混淆
	private int partition(String[] numStr, int start, int end) {
		String x = numStr[start];
		int pos = start;
		while (start < end) {
			while (start < end && compareTo(numStr[end], x) >= 0) {
				--end;
			}
			numStr[pos] = numStr[end];
			pos = end;

			while (start < end && compareTo(numStr[start], x) <= 0) {
				++start;
			}
			numStr[pos] = numStr[start];
			pos = start;
		}

		numStr[pos] = x;

		return pos;
	}

	private int compareTo(String m, String n) {
		String mn = m + n;
		String nm = n + m;

		return mn.compareTo(nm);
	}

	@Test
	public void test_minOrder2() {
		// 不能有0在里面,否则会出现以0开头的数
		int[] nums = { 2, 123, 21 };
		System.out.println(minOrder2(nums));
		int[] nums1 = { 21, 123, 21 };
		System.out.println(minOrder2(nums1));
		int[] nums2 = { 2 };
		System.out.println(minOrder2(nums2));
		int[] nums3 = { 2, 12 };
		System.out.println(minOrder2(nums3));
	}
}
