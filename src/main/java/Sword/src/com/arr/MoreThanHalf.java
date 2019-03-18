package Sword.src.com.arr;

import org.junit.Test;

public class MoreThanHalf {

	// 找出出现次数超过数组长度一半的数
	// 直观方式,Onlogn排序,然后On计算,快速排序或者归并排序
	public int moreThanHalf(int[] nums) {

		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		quickSort(nums, 0, nums.length - 1);
		
		int count = 1;
		int num = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] == num) {
				++count;
				if (count > nums.length / 2) {
					return num;
				}
			} else {
				num = nums[i];
				count = 1;
			}
		}

		return -1;
	}

	private void quickSort(int[] nums, int start, int end) {

		int mid = partition(nums, start, end);
		if (start < mid - 1)
			quickSort(nums, start, mid - 1);

		if (end > mid + 1)
			quickSort(nums, mid + 1, end);
	}

	private int partition(int[] nums, int start, int end) {
		int pos = start;
		int x = nums[start];
		while (start < end) {
			while (start < end && nums[end] >= x) {
				--end;
			}
			nums[pos] = nums[end];
			pos = end;

			while (start < end && nums[start] <= x) {
				++start;
			}
			nums[pos] = nums[start];
			pos = start;
		}
		nums[pos] = x;

		return pos;
	}

	@Test
	public void test_moreThanHalf() {

		int[] nums = { 2, 1, 2, 1, 2, 2, 2, 3, 4 };
		moreThanHalf(nums);
	}

	public int moreThanHalf2(int[] nums) {

		// 根据快速排序寻找中位数,如果正好是正中间一个,则再判断它出现的次数是否超过数组长度一半
		// 如果是超过数组长度一半的数,则这个排序的数组的中间元素一定是出现超过一半的数.
		if (nums == null || nums.length == 0) {
			return -1;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int middle = nums.length >> 1;
		int start = 0;
		int end = nums.length - 1;
		int index = partition(nums, start, end);
		while (index != middle) {
			if (index < middle) {
				start = index + 1;
				index = partition(nums, start, end);
			} else {
				end = index - 1;
				index = partition(nums, start, end);
			}
		}

		int count = 0;
		int num = nums[middle];
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == num) {
				count++;
			}
		}

		if (count > nums.length / 2) {
			return num;
		}

		return -1;
	}

	@Test
	public void test_moreThanHalf2() {

		int[] nums = { 2, 1, 2, 1, 2, 2, 2, 3, 4 };
		moreThanHalf2(nums);
	}

	public int moreThanHalf3(int[] nums) {

		// 出现次数超过一半则其出现次数超过其他所有数的出现次数,
		// 因此出现同一个数字+1,出现其他数字时-1,当次数减到0,把下个数标记

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int count = 1;
		int num = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			if (count == 0) {
				num = nums[i];
				count = 1;
			} else if (nums[i] == num) {
				++count;
			} else {
				--count;
			}
		}

		count = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == num) {
				++count;
			}
		}

		if (count > nums.length / 2) {
			return num;
		}

		return -1;
	}

	@Test
	public void test_moreThanHalf3() {

		int[] nums = { 2, 1, 2, 1, 2, 2, 2, 3, 4 };
		System.out.println(moreThanHalf3(nums));

		int[] nums1 = { 2 };
		System.out.println(moreThanHalf3(nums1));

		int[] nums2 = { 2, 1 };
		System.out.println(moreThanHalf3(nums2));

		System.out.println(moreThanHalf3(null));

	}
}
