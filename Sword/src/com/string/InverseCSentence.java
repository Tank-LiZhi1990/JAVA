package com.string;

import org.junit.Test;

/*
 * 翻转句子跟左旋有一定类似
 * 可以把左旋的n位看做一个单词,然后用相同的方法把它放到后面
 * 
 */
public class InverseCSentence {
	// 翻转指定的一段系列
	private void inverse(char[] str, int start, int end) {
		if (str == null || str.length == 1) {
			return;
		}
		// 前后交换
		char tmp = 0;
		while (start < end) {
			tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			++start;
			--end;
		}
	}

	// 翻转单词系列
	public void inverseCSentence(char[] str) {
		if (str == null || str.length == 1) {
			return;
		}

		// 翻转句子
		inverse(str, 0, str.length - 1);

		int start = 0;
		int end = 0;
		int length = str.length;
		while (start < length) {
			// 找到单词首
			while (start < length && str[start] == ' ') {
				++start;
			}
			// 找到单词尾
			end = start;
			while (end < length && str[end] != ' ' && str[end] != 0) {
				++end;
			}
			// 防止空格在末尾
			if (start < length) {
				// 翻转单词
				inverse(str, start, end - 1);
			}
			// 寻找下一个单词
			start = end + 1;
		}
	}

	@Test
	public void test_inverseCSentence() {
		String sen = "i am a student.";
		char[] str = sen.toCharArray();
		inverseCSentence(str);
		System.out.println(String.copyValueOf(str));

		char[] str1 = "i".toCharArray();
		inverseCSentence(str1);
		System.out.println(String.copyValueOf(str1));

		char[] str2 = "i ".toCharArray();
		inverseCSentence(str2);
		System.out.println(String.copyValueOf(str2));

		char[] str3 = "  ".toCharArray();
		inverseCSentence(str3);
		System.out.println(String.copyValueOf(str3));
	}

	// 左旋n位
	public void leftSpinN(char[] str, int n) {
		// 如果只有一个字母,旋转多少都是原来的,如果长度跟要旋转的长度相等,还是它本身
		if (str == null || n <= 0 || str.length == 1 || str.length == n) {
			return;
		}

		// 旋转超过字符长度,和取模后旋转的次数相同
		if (str.length < n) {
			n = n % str.length;
		}

		inverse2(str, 0, n - 1);
		inverse2(str, n, str.length - 1);

		inverse2(str, 0, str.length - 1);
	}

	private void inverse2(char[] str, int start, int end) {
		if (start == end) {
			return;
		}

		char tmp = 0;
		while (start < end) {
			tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			++start;
			--end;
		}
	}

	@Test
	public void test_leftSpinN() {
		String sen = "iamastudent.";
		char[] str = sen.toCharArray();
		leftSpinN(str, 2);
		System.out.println(String.copyValueOf(str));

		char[] str1 = "i".toCharArray();
		leftSpinN(str1, 1);
		System.out.println(String.copyValueOf(str1));

		char[] str2 = "iam".toCharArray();
		leftSpinN(str2, 2);
		System.out.println(String.copyValueOf(str2));

		char[] str3 = "iama".toCharArray();
		leftSpinN(str3, 5);
		System.out.println(String.copyValueOf(str3));
	}
}
