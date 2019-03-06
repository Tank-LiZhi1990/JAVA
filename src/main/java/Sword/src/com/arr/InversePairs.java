package Sword.src.com.arr;

import org.junit.Test;

public class InversePairs {

	// 逆序对的数目,利用辅助数组,加上归并排序原理,降低时间复杂度
	public int inversePairs(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] copy = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			copy[i] = nums[i];
		}

		return mergeSort(nums, copy, 0, nums.length - 1);
	}

	// 二路合并排序
	private int mergeSort(int[] nums, int[] copy, int start, int end) {
		if (start == end) {
			copy[start] = nums[start];
			return 0;
		}
		int mid = (start + end) / 2;
		int leftCount = mergeSort(copy, nums, start, mid);
		int rightCount = mergeSort(copy, nums, mid + 1, end);

		int leftEnd = mid;
		int rightEnd = end;
		int indexCopy = end;
		int count = 0;
		// 在比较的过程中进行排序
		while (leftEnd >= start && rightEnd >= mid + 1) {
			if (nums[leftEnd] > nums[rightEnd]) {
				count += rightEnd - mid;
				copy[indexCopy] = nums[leftEnd];
				--leftEnd;
			} else {
				copy[indexCopy] = nums[rightEnd];
				--rightEnd;
			}
			indexCopy--;
		}

		while (leftEnd >= start) {
			copy[indexCopy--] = nums[leftEnd--];
		}

		while (rightEnd >= mid + 1) {
			copy[indexCopy--] = nums[rightEnd--];
		}

		return leftCount + rightCount + count;
	}

	@Test
	public void test_inversePairs() {
		int[] nums = { 7, 5, 6, 4 };
		System.out.println(inversePairs(nums));
	}
}
