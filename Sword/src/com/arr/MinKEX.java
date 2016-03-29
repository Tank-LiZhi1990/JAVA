package com.arr;

import java.util.Arrays;

import org.junit.Test;

public class MinKEX {
	// 基于堆实现,首先创建大小为k的堆,然后遍历源数据,加入比当前堆中最大数小的数,重新调整堆
	// 该方法适合海量数据,复杂度为Onlogk,而且不需要改变原始数据的顺序
	// 1.创建大小为k的堆
	// 2.堆未满之前,持续加入数据
	// 3.调整堆
	// 4.继续遍历,更新数据并调整堆

	public int[] minKEx(int[] nums, int k) {

		if (nums == null || k <= 0 || nums.length < k) {
			return null;
		}

		int[] heap = new int[k];
		for (int i = 0; i < k; ++i) {
			heap[i] = nums[i];
		}

		initHeap(heap);

		for (int i = k; i < nums.length; ++i) {
			if (heap[0] > nums[i]) {
				heap[0] = nums[i];
				heapAjust(heap, 0);
			}
		}

		return heap;
	}

	private void initHeap(int[] heap) {

		int p = (heap.length - 1) >> 1;
		for (int i = p; i >= 0; --i) {
			heapAjust(heap, i);
		}
	}

	private void heapAjust(int[] heap, int i) {

		int child = 2 * i + 1;
		int length = heap.length;
		while (child < length) {
			if ((child + 1) < length && heap[child + 1] > heap[child]) {
				++child;
			}
			if (heap[i] < heap[child]) {
				int temp = heap[i];
				heap[i] = heap[child];
				heap[child] = temp;

				i = child;
				child = 2 * i + 1;
			} else {
				return;
			}
		}
	}

	@Test
	public void test_minKEx() {
		int[] nums = { 4, 5, 1, 4, 6, 8, 9, 0 };
		int[] result = minKEx(nums, 4);

		System.out.println(Arrays.toString(result));
	}
}
