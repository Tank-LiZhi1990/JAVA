package com.bit;

import org.junit.Test;

public class BitOperation {

	// 记录n中二进制位1的个数
	public int countOne(int n) {

		int count = 0;

		int i = 0;
		while (n != 0 && i < 32) {
			// 第i位为1
			if ((n & 1) == 1)
				++count;
			// if (n % 2 == 1)++count;//效率低些,实际编程中要尽量用移位代替乘除

			// 右移,检查下一位
			n = n >> 1;
			++i;
		}

		return count;
	}

	@Test
	public void test_countOne() {
		int n = 9;
		System.out.println(countOne(n));

		System.out.println(countOne(0));

		System.out.println(countOne(1));

		System.out.println(countOne(-1));

		System.out.println(countOne(100));
	}

	public int countOne2(int n) {
		int count = 0;
		int i = 32;
		int j = 1;
		// 一共只需循环32或64次,移动辅助数而不是数n本身
		while (i > 0) {
			if ((n & j) == j) {
				++count;
			}
			j = j << 1;
			--i;
		}
		return count;
	}

	@Test
	public void test_countOne2() {
		int n = 9;
		System.out.println(countOne2(n));

		System.out.println(countOne2(0));

		System.out.println(countOne2(1));

		System.out.println(countOne2(-1));

		System.out.println(countOne2(100));
	}

	public int countOne3(int n) {

		/*
		 * 一个数减去1,最右边的1变成0,它后面的0变成1,前面都保持不变
		 */

		int count = 0;
		while (n != 0) {
			++count;
			// 使最右边的1以及减1之后得到的1都变成0,相当于去掉最后一个1
			n = (n - 1) & n;
		}

		return count;
	}

	@Test
	public void test_countOne3() {
		int n = 9;

		System.out.println(countOne3(n));

		System.out.println(countOne3(0));

		System.out.println(countOne3(-1));

		System.out.println(countOne3(-10));
	}

	public boolean powerOf2(int n) {
		return ((n - 1) & n) == 0;
	}

	@Test
	public void test_powerOf2() {
		System.out.println(powerOf2(20));
		System.out.println(powerOf2(32));
		System.out.println(powerOf2(0));
		System.out.println(powerOf2(32768));

	}

	public int mTon(int m, int n) {
		// 变更多少位才能使m变成n

		int x = m ^ n;
		return countOne3(x);
	}

	@Test
	public void test_mTon() {
		System.out.println(2 ^ 3);
		System.out.println(Math.pow(2, 3));

		System.out.println(mTon(100, 110));
		System.out.println(mTon(0, -1));
		System.out.println(mTon(0, 0));
		System.out.println(mTon(1, -1));

		// swap
		// a=a^b;b=b^a;a=a^b;
	}
}
