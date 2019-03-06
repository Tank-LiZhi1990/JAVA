package Sword.src.com.arr;

import java.util.Arrays;

import org.junit.Test;

public class OneTimeInArray {
	// 数组中只出现一次的数
	// 任何数和自己异或结果都是0,整个数组异或结果就是那个只有一个的数
	// 求只出现一次的两个数,必须把这两个数分开,且子数组中数都是成对出现,可以根据最终结果中的1位分开两个不一样的数,并把相同的数分在一组
	public int[] oneTimeInArray(int[] arr) {

		if (arr == null || arr.length < 2) {
			return new int[2];
		}

		// 计算总的异或结果
		int result = 0;
		for (int i = 0; i < arr.length; ++i) {
			result = result ^ arr[i];
		}
		System.out.println(Integer.toBinaryString(result));
		// 找到1位所在位置
		int n = 1;
		for (int i = 1; i < 32; ++i) {
			if ((result & n) == n) {
				break;
			}
			n = n << 1;
		}

		int[] nums = new int[2];
		nums[0] = 0;
		nums[1] = 0;

		// 分开计算
		for (int i : arr) {
			if ((i & n) == n) {
				nums[0] = nums[0] ^ i;
			} else {
				nums[1] = nums[1] ^ i;
			}
		}

		return nums;
	}

	@Test
	public void test_oneTimeInArray() {

		int[] nums = { 1, 2, 3, 4, 2, 4 };
		System.out.println(Arrays.toString(oneTimeInArray(nums)));
		// System.out.println(Integer.toBinaryString(1 << 31));
		// System.out.println(1 << 31);
	}
}
