package com.lz;

//On2
public class SwapBubbleSort {
	public static void bubbleSort(int[] arr) {
		// 共需执行length-1次
		for (int i = 0; i < arr.length - 1; i++) {
			// 每冒泡一次,要比较的数少一个
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
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
		bubbleSort(arr);
		// print(arr);
	}
}
