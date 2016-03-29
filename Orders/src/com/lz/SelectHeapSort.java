package com.lz;

//复杂度O(nlog2n),
//深度为k=log2n向下取整+1;
//至多比较2(k-1)次,至多交换k-1次,
//循环堆调整花费2(log2(n-1)+log2(n-2)+...+log2)<2nlog2n向下取整,
//建堆比较次数<4n,所以复杂度为Onlog2n
public class SelectHeapSort {

	public static void heapSort(int[] arr) {
		initSort(arr);
		print(arr);
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;

			// i为实际长度
			heapAjust(arr, 0, i);
		}
	}

	private static void initSort(int[] arr) {
		// 最后一个有子节点的节点
		int lastnode = (arr.length - 1) / 2;
		// 依次向上调整
		for (int i = lastnode; i >= 0; i--) {
			heapAjust(arr, i, arr.length);
		}
	}

	/**
	 * @param arr
	 *            要调整的元数据
	 * @param i
	 *            要调整的节点
	 * @param length
	 *            元数据的长度
	 */
	private static void heapAjust(int[] arr, int i, int length) {
		// 要调整节点的左节点
		int child = 2 * i + 1;

		while (child < length) {
			// 选择字节的中较小的一个
			if ((child + 1) < length && arr[child + 1] < arr[child]) {
				child++;
			}
			// 如果自己的较小,交换,并调整子节点的树为堆
			if (arr[i] > arr[child]) {
				int temp = arr[i];
				arr[i] = arr[child];
				arr[child] = temp;

				i = child;
				child = 2 * i + 1;
			} else {
				break;
			}
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 7, 3, 8, 4, 9, 9, 6 };
		heapSort(arr);
		print(arr);
	}
}
