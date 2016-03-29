package com.lz;

public class SelectSimpleSortEx {

	public static void simpleSelectSortEx(int[] arr) {
		for (int i = 0; i <= arr.length / 2 - 1; i++) {
			int minPos = i;
			int maxPos = i;
			int temp;
			for (int j = i + 1; j <= arr.length - i - 1; j++) {
				if (arr[j] > arr[maxPos]) {
					maxPos = j;
					continue;
				}
				if (arr[j] < arr[minPos]) {
					minPos = j;
				}
			}

			if (maxPos == i && minPos == arr.length - i - 1) {
				temp = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = arr[i];
				arr[i] = temp;
			} else if (maxPos == i) {
				temp = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = arr[maxPos];
				arr[maxPos] = temp;

				temp = arr[i];
				arr[i] = arr[minPos];
				arr[minPos] = temp;
			} else {
				temp = arr[i];
				arr[i] = arr[minPos];
				arr[minPos] = temp;

				temp = arr[arr.length - i - 1];
				arr[arr.length - i - 1] = arr[maxPos];
				arr[maxPos] = temp;
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
		// TODO Auto-generated method stub
		int[] arr = { 1, 5, 3, 7, 3, 8, 4, 9, 9, 6 };
		simpleSelectSortEx(arr);
		print(arr);
	}
}
