package Sword.src.com.num;

import java.util.Arrays;

import org.junit.Test;

public class BigNumber {

	public void printMaxNBit(int n) {
		if (n <= 0) {
			return;
		}

		// 所有位填充为0;
		char[] nums = new char[n];
		Arrays.fill(nums, '0');

		System.out.println("0");
		// 当+1成功时,输出
		while (increaseNum(nums)) {
			printNum(nums);
		}
	}

	private boolean increaseNum(char[] nums) {
		int length = nums.length;
		// 表示进位,第一次循环是表示要+1
		boolean carry = true;
		for (int i = length - 1; i >= 0; --i) {
			// 进位了,继续循环
			if (carry) {
				// 如果最高位进位,则结束
				if (i == 0 && nums[i] == '9') {
					return false;
				}

				// 加法操作,carry表示进位
				if (nums[i] == '9') {
					carry = true;
					nums[i] = '0';
				} else {
					carry = false;
					nums[i] = (char) (nums[i] + 1);
				}
			} else {
				// 否则,退出循环
				break;
			}
		}

		return true;
	}

	private void printNum(char[] nums) {
		int length = nums.length;
		int i = 0;
		// 找到第一个不是 0 的位置
		while (i < length && nums[i] == '0') {
			++i;
		}

		// 从第一个不是 0 的位置开始,后面的数都输出
		if (i < length) {
			System.out.println(String.copyValueOf(nums, i, length - i) + " ");
		}
	}

	@Test
	public void test_printMaxNBit() {
		printMaxNBit(5);
		printMaxNBit(3);
		printMaxNBit(1);
		printMaxNBit(0);
		printMaxNBit(-1);
	}

	// 递归实现
	public void printMaxNBitEx(int n) {

		if (n <= 0) {
			return;
		}

		char[] nums = new char[n];
		Arrays.fill(nums, '0');

		int length = nums.length;

		for (int i = 0; i < 10; i++) {
			nums[0] = (char) (i + '0');
			printNumRecursively(nums, length, 0);
		}
	}

	private void printNumRecursively(char[] nums, int length, int index) {
		if (index == length - 1) {
			printNum(nums);
			return;
		}

		for (int i = 0; i < 10; i++) {
			nums[index + 1] = (char) (i + '0');
			printNumRecursively(nums, length, index + 1);
		}
	}

	@Test
	public void test_printMaxNBitEx() {
		printMaxNBitEx(5);
		printMaxNBitEx(3);
		printMaxNBitEx(1);
		printMaxNBitEx(0);
		printMaxNBitEx(-1);
		printMaxNBitEx(2);
	}

	// 不考虑负数
	public char[] twoNumberPlus(char[] num1, char[] num2) {
		if (num1.length == 0 || num2.length == 0) {
			return "0".toCharArray();
		}

		int m = num1.length;
		int n = num2.length;

		int biggerLength = m > n ? m : n;

		char[] num = new char[biggerLength];
		Arrays.fill(num, '0');

		boolean carry = false;
		int i = num.length - 1;
		while (m > 0 && n > 0) {
			char result = (char) (num1[m - 1] + num2[n - 1] - '0' - '0');
			if (carry) {
				result += 1;
			}

			if (result > 9) {
				carry = true;
				result -= 9;
			} else {
				carry = false;
			}

			num[i] = (char) (result + '0');

			--m;
			--n;
			--i;
		}

		while (m > 0) {
			num[i] = num1[m - 1];
			--m;
			--i;
		}

		while (n > 0) {
			num[i] = num2[n - 1];
			--n;
			--i;
		}

		return num;
	}

	@Test
	public void test_twoNumberPlus() {
		printNum(twoNumberPlus("123".toCharArray(), "4567".toCharArray()));
	}
}
