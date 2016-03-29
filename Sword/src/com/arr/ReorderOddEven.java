package com.arr;

import org.junit.Test;

//使用多态
public class ReorderOddEven implements CompareFunc {
	// 分类,前奇数,后偶数
	public void reorderOddEven(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return;
		}

		int start = 0;
		int end = nums.length - 1;

		while (start < end) {
			// 从前找到第一个偶数
			while ((nums[start] & 0x1) == 1 && start < nums.length) {
				++start;
			}
			// 从后向前找第一个奇数
			while ((nums[end] & 0x1) == 0 && end > 0) {
				--end;
			}

			// 没有交错时
			if (start < end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}
			++start;
			--end;
		}
	}

	public void printNums(int[] nums) {
		if (nums == null) {
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}

	@Test
	public void test_reorderOddEven() {
		int[] nums = { 1, 2, 4, 56, 7, 87, 8 };
		reorderOddEven(nums);
		printNums(nums);
		int[] nums1 = { 1 };
		reorderOddEven(nums1);
		printNums(nums1);
		int[] nums2 = { 1, 2 };
		reorderOddEven(nums2);
		printNums(nums2);
		int[] nums3 = { -1, -2, 1 };
		reorderOddEven(nums3);
		printNums(nums3);
	}

	// 通用性,不同比较也可以用该方法,实现接口的类自定义比较的方式
	public void reorderOddEvenEx(int[] nums, CompareFunc cp) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return;
		}

		int start = 0;
		int end = nums.length - 1;

		while (start < end) {

			while (cp.compareFunc(nums[start]) && start < nums.length) {
				++start;
			}

			while (!cp.compareFunc(nums[end]) && end > 0) {
				--end;
			}

			if (start < end) {
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}
			++start;
			--end;
		}
	}

	// if it is odd,return true
	@Override
	public boolean compareFunc(int num) {

		if ((num & 0x1) == 1) {
			return true;
		}

		return false;
	}
}
