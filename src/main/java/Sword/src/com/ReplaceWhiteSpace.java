package Sword.src.com;

public class ReplaceWhiteSpace {

	/*
	 * 从后向前移动可以使得数据的移动达到最小,时间复杂度降低;
	 * 这种方法还可以用于两个有序数组合并为一个有序数组,并把结果放在其中一个数组中(空间足够);
	 */
	public void replaceWhiteSpace(byte[] bytes) {
		if (bytes == null) {
			return;
		}
		int strlen = 0;
		int whiteSpace = 0;

		int i = 0;// 辅助循环序号
		while (bytes[i] != 0) {
			// 记录数组长度,非空部分
			strlen++;

			// AscII
			if (bytes[i] == 32) {
				whiteSpace++;
			}
			i++;
		}

		int newlen = strlen + 3 * whiteSpace;
		if (newlen > bytes.length) {
			return;
		}

		// 替换
		for (int j = strlen - 1; j >= 0; j--) {
			if (bytes[j] == 32) {
				bytes[newlen - 1] = '0';
				bytes[newlen - 2] = '2';
				bytes[newlen - 3] = '%';
				newlen -= 3;
			} else {
				bytes[newlen - 1] = bytes[j];
				newlen--;
			}
		}
	}

	public static void main(String[] args) {
		byte[] hello = new byte[20];
		byte[] temp = "hello world!".getBytes();
		for (int i = 0; i < temp.length; i++) {
			hello[i] = temp[i];
		}
		new ReplaceWhiteSpace().replaceWhiteSpace(hello);
		System.out.println(new String(hello));
	}

}
