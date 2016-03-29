package com.lz;

public class SwapQuickSortEx {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 7, 3, 8, 4, 9, 9, 6 };
		quickSortEx(arr, 0, arr.length - 1);
		print(arr);

		/*
		 * quickSortEx2; 先对大于k的子序列用快速排序进行排序, 使系列基本有序,再通过对结果运用插入排序算法进行排序,
		 * 复杂度会有所降低,当K取8左右时,性能最佳.
		 * 
		 */
	}

	private static void swap(int arr[], int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}

	private static int partition(int[] arr, int low, int high) {
		// 取 low mid high中中间的一个
		int mid = (high + low) / 2;
		if (arr[high] < arr[low]) {
			if (arr[high] > arr[mid]) {
				// swap
				swap(arr, high, low);
			} else if (arr[mid] < arr[low]) {
				// swap
				swap(arr, mid, low);
			}
		} else {
			if (arr[mid] > arr[low]) {
				if (arr[mid] < arr[high]) {
					// swap
					swap(arr, mid, low);
				} else if (arr[mid] > arr[high]) {
					swap(arr, high, low);
				}
			}
		}
		int x = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= x) {
				high--;
			}
			int temp = arr[high];
			arr[high] = arr[low];
			arr[low] = temp;

			while (low < high && arr[low] <= x) {
				low++;
			}
			temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
		}

		print(arr);

		return low;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void quickSortEx(int[] arr, int low, int high) {
		if (low < high) {
			int pos = partition(arr, low, high);
			// if(pos-1-low >= 8)
			quickSortEx(arr, low, pos - 1);
			// else{InsertSort(arr,low,pos-1);}

			// if(high-pos-1 >= 8)
			quickSortEx(arr, pos + 1, high);
			// else{InsertSort(arr,pos+1,high);}
		}
	}
}
