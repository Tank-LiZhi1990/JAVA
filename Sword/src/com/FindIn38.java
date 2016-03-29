package com;

public class FindIn38 {
	/*
	 * 只能选择右上或者左下作为遍历的起点,缩小 范围; 矩阵的左边都小于右边,上边都小于下边,寻找是否存在n
	 */
	public boolean findIn(int[][] nums, int n) {

		if (nums.length == 0) {
			return false;
		}
		int width = nums[0].length;
		int height = nums.length;

		int i = width - 1;
		int j = 0;
		while (i >= 0 && j < height) {
			if (nums[j][i] == n) {
				return true;
			} else if (nums[j][i] > n) {
				// 列范围减少
				i--;
			} else if (nums[j][i] < n) {
				// 行范围减少
				j++;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int n = 15;
		int[][] nums1 = {};
		System.out.println(new FindIn38().findIn(nums, n));
		System.out.println(new FindIn38().findIn(nums1, n));
	}
}
