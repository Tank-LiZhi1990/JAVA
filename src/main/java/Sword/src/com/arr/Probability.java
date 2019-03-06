package Sword.src.com.arr;

import java.util.Arrays;

import org.junit.Test;

public class Probability {

	private static final int FACE_COUNT = 6;

	// 计算n个骰子每种组合出现的概率
	public void probability(int n) {
		if (n <= 0) {
			return;
		}

		int[] possibleSum = new int[FACE_COUNT * n - n + 1];
		Arrays.fill(possibleSum, 0);

		recursiveCount(possibleSum, n, n, 0);

		for (int i = 0; i < possibleSum.length; ++i) {
			System.out.println((i + n) + " --- " + possibleSum[i] + "/" + (int) Math.pow(FACE_COUNT, n));
		}
	}

	/**
	 * @param possibleSum
	 *            存放出现次数的数组
	 * @param length
	 *            递归参数,表示剩余的骰子的数目
	 * @param n
	 *            总共有多少骰子
	 * @param sum
	 *            当前累加和
	 */
	private void recursiveCount(int[] possibleSum, int length, int n, int sum) {
		// 遍历完所有骰子
		if (length == 0) {
			possibleSum[sum - n]++;
			return;
		}

		// 计算假设当前骰子值为i时剩余骰子可能的和
		for (int i = 1; i <= FACE_COUNT; ++i) {
			sum += i;
			recursiveCount(possibleSum, length - 1, n, sum);
			sum -= i;
		}
	}

	@Test
	public void test_probability() {
		probability(3);

	}

	/*
	 * 用两个数组,第二个数组的第i个值等于前一个数组该值及其前五个值的和(如果有的话),然后交换数组
	 * 
	 * 时间复杂度
	 */
	public void probability2(int n) {
		if (n <= 0) {
			return;
		}

		int[] possibleSum1 = new int[FACE_COUNT * n - n + 1];
		int[] possibleSum2 = new int[FACE_COUNT * n - n + 1];
		Arrays.fill(possibleSum1, 0);
		Arrays.fill(possibleSum2, 0);

		for (int i = 0; i < FACE_COUNT; ++i) {
			possibleSum1[i] = 1;
		}

		int[] tmp;
		int curLength = FACE_COUNT;
		for (int j = 1; j < n; ++j) {
			curLength = FACE_COUNT * (j + 1) - j;
			for (int i = 0; i < curLength; ++i) {
				possibleSum2[i] = 0;
				for (int k = 0; k < FACE_COUNT; ++k) {
					if (i - k < 0) {
						break;
					}
					possibleSum2[i] += possibleSum1[i - k];
				}
			}
			tmp = possibleSum1;
			possibleSum1 = possibleSum2;
			possibleSum2 = tmp;
		}

		for (int i = 0; i < possibleSum1.length; ++i) {
			System.out.println((i + n) + " --- " + possibleSum1[i] + "/" + (int) Math.pow(FACE_COUNT, n));
		}
	}

	@Test
	public void test_probability2() {
		probability2(3);
	}
}
