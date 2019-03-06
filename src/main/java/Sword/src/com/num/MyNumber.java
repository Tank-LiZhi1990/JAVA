package Sword.src.com.num;

import org.junit.Test;

public class MyNumber {

	// 求指数值
	public double power(double base, int exponent) {

		// 考虑边界,0^0,指数为负,0不能为分母

		// 这样比较有问题,在计算机中保存小数时都有误差(float\double)
		// if (base == 0.0) {
		// return 0.0;
		// }

		// double类型比较要按精度比较，差值在这个范围内被认为是相等的
		if (base - 0.0 < 0.0000001 && base - 0.0 > -0.0000001) {
			if (exponent >= 0) {
				return 0.0;
			} else {
				throw new RuntimeException("Invalid base and exponent");
			}
		}

		if (exponent == 0) {
			return 1.0;
		}

		if (exponent == 1) {
			return base;
		}

		double result = 1.0;
		int positiveExponnet = Math.abs(exponent);

		for (int i = 0; i < positiveExponnet; ++i) {
			result = result * base;
		}

		if (exponent < 0) {
			return 1.0 / result;
		}

		return result;
	}

	public double powerEx(double base, int exponent) throws Exception {

		if (base - 0.0 < 0.0000001 && base - 0.0 > -0.0000001) {
			if (exponent >= 0) {
				return 0.0;
			} else {
				throw new Exception("Invalid base and exponent");
			}
		}

		double result = 1.0;
		int positiveExponnet = Math.abs(exponent);
		result = powerWithPositiveExponent(base, positiveExponnet);

		if (exponent < 0) {
			return 1.0 / result;
		}

		return result;
	}

	// a=a^(n/2)*a^(n/2) / a=a^((n-1)/2)*a^((n-1)/2)*a
	private double powerWithPositiveExponent(double base, int exponent) {
		if (exponent == 0) {
			return 1.0;
		}

		if (exponent == 1) {
			return base;
		}

		// 计算a^(n/2) 或者 a^((n-1)/2)
		double result = powerWithPositiveExponent(base, exponent >> 1);
		result *= result;
		// 奇数
		if ((exponent & 0x1) == 0x1) {
			result *= base;
		}

		return result;
	}

	@Test
	public void test_power() {
		System.out.println(power(3.0, 2));
		System.out.println(power(3.0, 0));
		System.out.println(power(3.0, -1));
		System.out.println(power(0.0, 0));
		// System.out.println(power(0.0, -1));
		System.out.println(power(-2, -1));

	}

	@Test
	public void test_powerEx() {
		// 抛运行时异常会引起程序退出或线程中止
		try {
			System.out.println(powerEx(3.0, 2));
			System.out.println(powerEx(3.0, 0));
			System.out.println(powerEx(3.0, -1));
			System.out.println(powerEx(0.0, -1));
			System.out.println(powerEx(0.0, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
