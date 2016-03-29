package com.lz;

//希尔排序,不稳定的排序方法,时间复杂度依赖于dk,取奇数或质数,除1外没有公因子
public class InsertShellSort {
	public static void shellInsert(int arr[]) {
		// dk from len/2 -> 1
		int dk = arr.length / 2;
		while (dk >= 1) {
			// 执行直接插入排序
			insertSort(arr, dk);
			dk /= 2;
		}
	}

	private static void insertSort(int[] arr, int dk) {
		for (int i = dk; i < arr.length; i++) {
			if (arr[i] < arr[i - dk]) {
				int j = i - dk;
				int x = arr[i];
				while (j >= 0 && x < arr[j]) {
					arr[j + dk] = arr[j];
					j -= dk;
				}
				arr[j + dk] = x;
			}
			print(arr);
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
		shellInsert(arr);
		print(arr);
	}

}
