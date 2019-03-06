package Sword.src.com;

public class OneToN {

	// &&运算,只有前面为真时后面才会执行
	public int fun(int n) {
		boolean whatever = false;
		int re = 0;
		whatever = (n != 0) && ((re = fun(n - 1)) != 0);

		return re + n;
	}

	private static int sum = 0;

	// ||运算,当前面为真时,后面不再计算
	public boolean fun2(int n) {
		sum += n;
		return n <= 0 || fun2(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(new OneToN().fun(100));

		new OneToN().fun2(100);
		System.out.println(OneToN.sum);
	}
}
