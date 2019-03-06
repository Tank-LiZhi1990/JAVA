package Orders.src.com.lz;

//空间复杂度为On,时间复杂度为Onlog2n
public class MergeSort {
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 5, 3, 7, 3, 8, 4, 9, 9, 6 };
		int[] tempArr = new int[arr.length];
		mergeSort(arr, tempArr);
		print(arr);
	}

	public static void mergeSort(int[] arr, int[] tempArr) {
		int arrLength = arr.length;
		// 子数组长度1,2,4,8...
		int len = 1;
		while (len < arrLength) {
			int cur = len;
			// 2个用于合并的数组的总长度
			len = 2 * cur;
			// 下标
			int i = 0;
			// 处理两个相同大小的数组
			while ((i + len) < arrLength) {
				mergeTwo(arr, tempArr, i, i + cur - 1, i + len - 1);
				i += len;
			}
			// 处理两个不同大小的数组,多于一个子数组,且第二个不满时
			if (i + cur < arrLength) {
				mergeTwo(arr, tempArr, i, i + cur - 1, arrLength - 1);
			}

			// 交换数组,进行下一次合并
			int[] temp = arr;
			arr = tempArr;
			tempArr = temp;

			print(arr);
		}
	}

	/**
	 * @param arr
	 *            元数据
	 * @param tempArr
	 *            放入排序后的数组
	 * @param start1
	 *            第一个数组的起始下标
	 * @param end1
	 *            第一个数组的末尾下标
	 * @param end2
	 *            第二个数组的末尾下标
	 */
	private static void mergeTwo(int[] arr, int[] tempArr, int start1, int end1, int end2) {
		// 第二个数组的起始下标
		int start2 = end1 + 1;
		// 临时数组的下标
		int copyIndex = start1;
		while (start1 <= end1 && start2 <= end2) {
			if (arr[start1] < arr[start2]) {
				tempArr[copyIndex] = arr[start1];
				start1++;
			} else {
				tempArr[copyIndex] = arr[start2];
				start2++;
			}
			copyIndex++;
		}
		// 如果第一个数组还有剩余
		while (start1 <= end1) {
			tempArr[copyIndex] = arr[start1];
			start1++;
			copyIndex++;
		}
		// 如果第二个数组还有剩余
		while (start2 <= end2) {
			tempArr[copyIndex] = arr[start2];
			start2++;
			copyIndex++;
		}
	}
}
