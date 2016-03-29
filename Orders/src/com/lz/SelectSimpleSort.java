package com.lz;

public class SelectSimpleSort {

	public static void simpleSelect(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int pos = i;
			int min = arr[i];
			// 寻找最小的元素
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					pos = j;
					min = arr[j];
				}
			}
			// 将该元素放到相应位置
			if (pos != i) {
				arr[pos] = arr[i];
				arr[i] = min;
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
		simpleSelect(arr);
		print(arr);
	}

}
