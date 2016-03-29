package com.arr;

import org.junit.Test;

/*
 * 年龄在一定范围内,则通过辅助一个100大小的数组,计算每个年龄出现的次数,然后再将原数组里按顺序赋值出现的次数次.
 * 空间复杂度O1,时间复杂度On  (2n)
 */
public class AgeOrder {

	private static final int OLDESTAGE = 99;

	public void sortAge(int[] ages) {
		int[] timesOfAge = new int[OLDESTAGE];

		for (int i = 0; i < ages.length; ++i) {
			if (ages[i] < 0 || ages[i] > OLDESTAGE) {
				throw new IllegalArgumentException("Invalid age.");
			}

			timesOfAge[ages[i]]++;
		}

		int index = 0;
		for (int i = 0; i < OLDESTAGE; ++i) {
			for (int j = 0; j < timesOfAge[i]; ++j) {
				ages[index] = i;
				++index;
			}
		}
	}

	@Test
	public void test_sortAge() {
		int[] ages = { 2, 3, 54, 6, 78, 8, 9, 9, 0, 4, 3, 22, 2, 5, 67, 7, 8, 9, 1 };
		sortAge(ages);

		for (int i = 0; i < ages.length; ++i) {
			System.out.print(ages[i] + " ");
		}
	}
}
