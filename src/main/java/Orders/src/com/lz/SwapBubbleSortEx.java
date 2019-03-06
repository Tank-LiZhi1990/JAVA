package Orders.src.com.lz;

public class SwapBubbleSortEx {

	public static void bubbleSortEx(int[] arr) {
		boolean exchange = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					exchange = true;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!exchange) {
				return;
			}
			exchange = false;
			print(arr);
		}
	}

	public static void bubbleSortEx2(int[] arr) {
		int i = arr.length - 1;

		while (i > 0) {
			// pos记录最后一次交换的位置,如果没交换则pos为0
			int pos = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					pos = j;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			i = pos;
			print(arr);
		}
	}

	public static void bubbleSortEx3(int[] arr) {
		int high = arr.length - 1;
		int low = 0;

		while (high > low) {
			for (int i = low; i < high; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			high--;
			for (int i = high; i > low; i--) {
				if (arr[i] < arr[i - 1]) {
					int temp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = temp;
				}
			}
			low++;
		}
		print(arr);
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 7, 3, 8, 4, 9, 9, 6 };
		// bubbleSortEx(arr);
		// bubbleSortEx2(arr);
		bubbleSortEx3(arr);
	}
}
