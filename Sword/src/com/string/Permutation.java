package com.string;

import org.junit.Test;

//全排列
public class Permutation {
	static int count = 1;

	public void permutation(char[] s) {
		if (s == null || s.length == 0) {
			return;
		}

		permutationRecursively(s, 0);
	}

	private void permutationRecursively(char[] s, int start) {

		if (start == s.length - 1) {
			System.out.println(count++ + "->" + String.copyValueOf(s));
		}

		// 每次交换当前字符和后面的某一个字符,并求剩下字符的全排列
		for (int i = start; i < s.length; ++i) {
			char c = s[start];
			s[start] = s[i];
			s[i] = c;

			permutationRecursively(s, start + 1);

			c = s[start];
			s[start] = s[i];
			s[i] = c;
		}
	}

	@Test
	public void test_permutation() {
		String str = "abcde";
		permutation(str.toCharArray());
	}
}
