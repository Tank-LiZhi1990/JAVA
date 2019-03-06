package Sword.src.com.recursion;

import org.junit.Test;

public class Fibonacci {

	// 不好的解法
	public int fibonacci(int n) {

		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	@Test
	public void test_fibonacci() {
		int n = 10;
		System.out.println(fibonacci(n));

		System.out.println(fibonacci(0));
	}

	// 从小到大的方式
	public int fibonacciEx(int n) {

		if (n < 0) {
			return 0;
		}

		if (n < 2) {
			return n;
		}
		int smallerOne = 0;
		int biggerOne = 1;

		int next = 0;

		int i = 2;
		while (i <= n) {
			next = smallerOne + biggerOne;
			smallerOne = biggerOne;
			biggerOne = next;

			i++;
		}

		return next;
	}

	@Test
	public void test_fibonacciEx() {
		int n = 10;

		System.out.println(fibonacciEx(n));

		System.out.println(fibonacciEx(0));
		System.out.println(fibonacciEx(1));
		System.out.println(fibonacciEx(2));

		System.out.println(fibonacciEx(-1));

		System.out.println(fibonacciEx(40));
	}

	/*
	 * 如果青蛙一次可以跳1个或者2个或者3个....;
	 * 可以将台阶看做球,向n-1个空隙插入板子,一共有C(N-1,0)+C(N-2,1)+....+C(N-1,N-1)共2^(n-1)种;
	 */

	/*
	 * 1x2矩形覆盖问题也是同理,如果横着放,剩下的为n-1,如果竖着放,剩下的为n-2
	 */

}
