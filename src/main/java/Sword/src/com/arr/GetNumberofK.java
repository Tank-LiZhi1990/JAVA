package Sword.src.com.arr;

import org.junit.Test;

public class GetNumberofK {
	// 计算在排序数组中k出现的次数
	public int getNumberOfK(int[] nums, int k) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int count = 0;
		int pos1 = getFirstK(nums, k, 0, nums.length - 1);
		int pos2 = getLastK(nums, k, 0, nums.length - 1);
		if (pos1 >= 0) {
			count = pos2 - pos1 + 1;
		}

		return count;
	}

	private int getFirstK(int[] nums, int k, int start, int end) {
		if (start > end) {
			return -1;
		}

		// int pos = -1;
		int mid = (end + start) / 2;
		if (nums[mid] > k) {
			end = mid - 1;
			// pos = getFirstK(nums, k, start, mid - 1);
		} else if (nums[mid] < k) {
			start = mid + 1;
			// pos = getFirstK(nums, k, mid + 1, end);
		} else {
			if (mid > 0 && nums[mid - 1] == k) {
				end = mid - 1;
				// pos = getFirstK(nums, k, start, mid - 1);
			} else {
				// pos = mid;
				return mid;
			}
		}
		// return pos;
		return getFirstK(nums, k, start, end);
	}

	private int getLastK(int[] nums, int k, int start, int end) {
		if (start > end) {
			return -1;
		}

		// int pos = -1;
		int mid = (end + start) / 2;
		if (nums[mid] > k) {
			end = mid - 1;
			// pos = getLastK(nums, k, start, mid - 1);
		} else if (nums[mid] < k) {
			start = mid + 1;
			// pos = getLastK(nums, k, mid + 1, end);
		} else {
			if ((mid + 1) < nums.length && nums[mid + 1] == k) {
				start = mid + 1;
				// pos = getLastK(nums, k, mid + 1, end);
			} else {
				// pos = mid;
				return mid;
			}
		}
		// return pos;
		return getLastK(nums, k, start, end);
	}

	@Test
	public void test_getNumberOfK() {
		int[] nums = { 9, 10 };
		System.out.println(getNumberOfK(nums, 10));
		
		int[] nums1 = { 1, 2, 3, 3, 3, 3, 4, 5 };
		System.out.println(getNumberOfK(nums1, 3));
		
		int[] nums2 = { 9 };
		System.out.println(getNumberOfK(nums2, 10));
		
		int[] nums3 = { 9, };
		System.out.println(getNumberOfK(nums3, 9));
	}
}
