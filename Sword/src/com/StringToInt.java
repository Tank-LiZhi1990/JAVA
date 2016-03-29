package com;

public class StringToInt {

	enum g_status {
		VALID, INVALID
	};

	private g_status val = g_status.VALID;

	// 错误处理使用异常或者全局变量
	public int stringToInt(String str) {
		// 线程安全问题
		val = g_status.VALID;

		if (str == null || str.length() == 0) {
			val = g_status.INVALID;
			return 0;
		}

		char[] nums = str.toCharArray();
		boolean positive = true;
		int index = 0;
		if (nums[index] == '-') {
			positive = false;
			++index;
		} else if (nums[index] == '+') {
			++index;
		}

		long result = 0;
		for (int i = index; i < nums.length; ++i) {
			if (nums[i] <= '9' && nums[i] >= '0') {
				if (positive) {
					result = result * 10 + nums[i] - '0';
					if (result > 0x7fffffff) {
						val = g_status.INVALID;
						return 0;
					}
				} else {
					result = result * 10 + (-1) * (nums[i] - '0');
					if (result < 0x80000000) {
						val = g_status.INVALID;
						return 0;
					}
				}
			} else {
				val = g_status.INVALID;
				return 0;
			}
		}

		return (int) result;
	}

	public g_status getVal() {
		return val;
	}

	public static void main(String[] args) {
		/*
		 * int i = -1 * Integer.MAX_VALUE; for (int j = 0; i < 10000; ++j) {
		 * i--; if (i > 0) { break; } System.out.println(i); }
		 * System.out.println(0x80000000);
		 * System.out.println(Integer.MAX_VALUE);
		 * System.out.println(Integer.MAX_VALUE + 1);
		 * 
		 * System.out.println(0x7fffffff);
		 */

		StringToInt obj = new StringToInt();
		System.out.println(obj.stringToInt("123512345124"));
		System.out.println(obj.getVal() == g_status.VALID);
		
		System.out.println(obj.stringToInt("1235"));
		System.out.println(obj.getVal() == g_status.VALID);
		
		System.out.println(obj.stringToInt("-1235"));
		System.out.println(obj.getVal() == g_status.VALID);
		
		System.out.println(obj.stringToInt("-1235a"));
		System.out.println(obj.getVal() == g_status.VALID);
	}
}
