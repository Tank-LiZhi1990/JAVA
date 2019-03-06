package Sword.src.com.string;

import org.junit.Test;

public class Combinations {

	public void combinations(char[] s) {
		if (s == null || s.length == 0) {
			return;
		}

		// 存放已经准备要输出的字符
		char[] temp = new char[s.length];
		// m表示要输出的字符的长度，即m个字母的组合
		for (int m = 1; m <= s.length; ++m) {
			printRemaining(s, 0, m, temp, 0);
		}
	}

	/**
	 * c(n,m)=c(n,1)c(n,m-1)+c(n-1,m-1)
	 * 
	 * @param s
	 *            源数组
	 * @param start
	 *            起始下标
	 * @param m
	 *            剩余长度
	 * @param tmp
	 *            临时存放将要输出的字符
	 * @param cur
	 *            临时数组当前字符所在位置
	 */
	private void printRemaining(char[] s, int start, int m, char[] tmp, int cur) {
		// 当选好字符后，输出
		if (m == 0) {
			System.out.println(String.copyValueOf(tmp, 0, cur));
			return;
		}

		// 未选好且尚未到达源数组末尾
		if (m > 0 && start < s.length) {
			// 将当前字符添加到临时数组中
			tmp[cur++] = s[start];
			// 继续寻找剩下的m-1个字符
			printRemaining(s, start + 1, m - 1, tmp, cur);

			// 将当前字符从临时数组去除
			--cur;
			tmp[cur] = 0;
			// 在剩余数组中寻找m个字符
			printRemaining(s, start + 1, m, tmp, cur);
		}
	}

	@Test
	public void test_combinations() {
		String s = "abcd";
		combinations(s.toCharArray());
	}
}
