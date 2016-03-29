package com.lz;

// 直接插入排序 O(n^2)
public class InsertSort {

	public static void insertSort(int[] arr) {
		// arr is null? or len = 0?
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				// 取出最后一个排序好的数
				int j = i - 1;
				// 取出待插入的数
				int x = arr[i];
				// 后移比x大的数
				while (j >= 0 && x < arr[j]) {
					arr[j + 1] = arr[j];
					j--;
				}
				// 将x插入到正确位置
				arr[j + 1] = x;
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
		// TODO Auto-generated method stub
		int[] arr = { 1, 5, 3, 7, 3, 8, 4, 9, 9, 6 };
		insertSort(arr);
		print(arr);
	}

}
