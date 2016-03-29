package com.lz;

//平均性能最好,若初始时数据基本有序,则退化为冒泡,不稳定
public class SwapQuickSort {
	/*
	 * 选择一个元素x,一般为第一个或最后一个 通过一趟排序将数据分成两部分,一部分比x小,一部分比x大 此时x在正确位置,再分别对两部分进行排序
	 */

	public static int partition(int[] arr, int low, int high) {
		int x = arr[low];
		// 可以看做把low的位置变成空,把右边的小数换到空位置,把左边的大数换到右边刚腾出来的空位置.
		while (low < high) {
			while (low < high && arr[high] >= x) {
				high--;
			}
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;

			while (low < high && arr[low] <= x) {
				low++;
			}
			temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
		}

		print(arr);
		// 此时low>=high,且arr[low]=x
		return low;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			// 获得x所在位置
			int pos = partition(arr, low, high);
			// 排序小于x部分
			quickSort(arr, low, pos - 1);
			// 排序大于x部分
			quickSort(arr, pos + 1, high);
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
		quickSort(arr, 0, arr.length - 1);
		print(arr);
	}
}
