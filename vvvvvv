package sort;

import util.Utils;

public class SortDemo {
	
	/*
	 * 冒泡排序
	 * 时间复杂度：最好O(n)，最坏O(n^2)
	 * 稳定性：稳定
	 */
	public void bubbleSort(int[] arr) {
		boolean flag;
		for (int i = 0; i < arr.length - 1; i++) {
			flag = true;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j+1]) {
					Utils.swap(arr, j, j+1);
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
	}
	
	/*
	 * 选择排序
	 */
	public void selectSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				Utils.swap(arr, minIndex, i);
			}
		}
	}
	
	/*
	 * 插入排序
	 * 时间复杂度：最好O(n)，最坏O(n^2)
	 * 稳定性：稳定
	 */
	public void insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j;
			for (j = i; j > 0 && arr[j-1] > temp; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = temp;
		}
	}
	
	/*
	 * 希尔排序
	 * 时间复杂度：最坏O(n^2)
	 * 稳定性：不稳定
	 */
	public void shellSort(int[] arr) {
		for (int k = arr.length / 2; k > 0; k /= 2) { // 增量序列
			for (int i = k; i < arr.length; i++) {
				int temp = arr[i];
				int j;
				for (j = i; j >= k && arr[j-k] > temp; j -= k) {
					arr[j] = arr[j-k];
				}
				arr[j] = temp;
			}
		}
	}
	
	/*
	 * 堆排序
	 */
	public void heapSort(int[] arr) {
		int length = arr.length;
		// 构建大顶堆
		for (int i = length / 2 - 1; i >= 0; i--) {
			heapAdjust(arr, i, length);
		}
		// 排序
		for (int i = length - 1; i > 0; i--) {
			// 交换堆顶（数组第一个元素）和无序段的最后一个元素
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			// 重新将无序段调整为大顶堆
			heapAdjust(arr, 0, i-1);
		}
	}
	
	private void heapAdjust(int[] arr, int i, int heapSize) {
		int left = 2 * i + 1;
		int right = left + 1;
		int maxIndex = i;
		if (left < heapSize && arr[left] > arr[maxIndex])
			maxIndex = left;
		if (right < heapSize && arr[right] > arr[maxIndex])
			maxIndex = right;
		if (maxIndex != i) {
			Utils.swap(arr, i, maxIndex);
			heapAdjust(arr, maxIndex, heapSize);
		}
	}

	public void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
		
	}
	
	private void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right-left) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr, left, mid, right);
		}
	}
	
	private void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[arr.length];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		for (i = 0; i < k; i++) {
			arr[left+i] = temp[i];
		}
	}

	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	private void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int index = partition(arr, left, right);
			quickSort(arr, left, index-1);
			quickSort(arr, index+1, right);
		}
	}

	private int partition(int[] arr, int left, int right) {
		int pivot = arr[left]; // select the first element as pivot
		while (left < right) {
			while (left < right && arr[right] >= pivot)
				right--;
			arr[left] = arr[right];
			while (left < right && arr[left] <= pivot)
				left++;
			arr[right] = arr[left];
		}
		// now left is equal to right
		arr[left] = pivot;
		return left;
	}

	
	
	
	
	
	
	
}
