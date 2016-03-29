package com.arr;

public class Count1Times {

	public int count1Times(int n, int x) {
		if (n <= 0 || x <= 0) {
			return -1;
		}
		// x∈(1,9)
		// 1-10有一个x (10/10)
		// 1-100,十位上有10个x (100/10)
		// 1-1000,百位上有100个x (1000/10)
		// 所以计算n有几个10,几个百,几个千...
		int count = 0;

		int k = n / 1;
		for (int i = 1; k > 0; i *= 10) {
			k = n / i;
			// k/10,几个十,百,千...
			count += (k / 10) * i;// a
			// 补上低位的个数,第i位数的值
			int cur = k % 10;
			if (cur > x) {
				count += i;// a+i(i=10^(i-1))
			} else if (cur == x) {
				count += n - k * i + 1;// a+b+1,b是1-i位代表的数
			}
			// cur<x时,低位没有
		}

		return count;
	}

	public int count1Times2(int n, int x) {
		// x=0
		int count = 0;

		return count;
	}
}
