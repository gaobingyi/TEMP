public class Sort {

	/*
	 * Bubble Sort
	 */
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j+1]) {
					swap(array, j, j+1);
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
	}
	
	/*
	 * Select Sort
	 */
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i; // 假设第一个元素最小
			for (int j = i+1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(array, minIndex, i);
			}
		}
	}
	
	/*
	 * Insert Sort
	 */
	public static void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			/*int j = i;
			while (j > 0 && array[j] < array[j-1]) {
				swap(array, j, j-1);
				j--;
			}*/
			
			int temp = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > temp) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}
	
	private static void swap(int[] array, int s, int t) {
		int temp = array[s];
		array[s] = array[t];
		array[t] = temp;
	}
	
	/*
	 * Quick Sort
	 */
	public void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		
	}

	private void quickSort(int[] nums, int l, int r) {
		if (l >= r) {
			return;
		}
		int i = patition(nums, l, r);
		quickSort(nums, l, i - 1);
		quickSort(nums, i + 1, r);
	}

	private int patition(int[] nums, int l, int r) {
		int privot = nums[l];
		while (l < r) {
			while (l < r && nums[r] >= privot) {
				r--;
			}
			nums[l] = nums[r];
			while (l < r && nums[l] <= privot) {
				l++;
			}
			nums[r] = nums[l];
		}
		nums[l] = privot;
		return l;
	}
	
	/*
	 * Merge Sort
	 */
	public void mergeSort(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
	}

	private void mergeSort(int[] nums, int l, int r) {
		if (l >= r) {
			return;
		}
		int m = l + (r - l) / 2;
		mergeSort(nums, 0, m);
		mergeSort(nums, m + 1, r);
		merge(nums, r, l, m);
	}

	private void merge(int[] nums, int r, int l, int m) {
		int[] arr = new int[r - l + 1];
		int i = l;
		int j = m + 1;
		int k = 0;
		while (i <= l && j <= r) {
			arr[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
		}
		while (i <= l) {
			arr[k++] = nums[i++];
		}
		while (j <= r) {
			arr[k++] = nums[j++];
		}
		for (i = 0; i < k; i++) {
			nums[l + i] = arr[i];
		}
	}
	
	/*
	 * Shell Sort
	 */
	public static void shellSort(int[] nums) {
		// 对所有增量：length/2 =减半=> 0
		for (int gap = nums.length / 2; gap > 0; gap /= 2) {
			// 对每一个增量下所有组
			for (int i = 0; i < gap; i++) {
				// 对每一组直接插入排序
				for (int j = i + gap; j < nums.length; j++) {
					int temp = nums[j];
					int k = j - gap;
					while (k >= 0 && nums[k] > temp) {
						nums[k+gap] = nums[k];
						k -= gap;
					}
					nums[k+gap] = temp;
				}
			}
			
		}
	}
	
	/*
	 * Heap Sort
	 */
	public static void heapSort(int[] nums) {
		int length = nums.length;
		// 建立大顶堆
		for (int i = length / 2; i >= 0; i--) {
			heapAdjust(nums, i, length);
		}
		// 排序
		for (int i = length - 1; i > 0; i--) {
			// 交换堆顶和无序段的最后一个元素
			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
			// 重新将无序段调整为大顶堆
			heapAdjust(nums, 0, i-1);
		}
	}
	private static void heapAdjust(int[] nums, int i, int size) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i; // 假设父节点最大
		if (i <= size / 2) { // 判断是否是非叶子结点
			if (left < size && nums[left] > nums[max])
				max = left;
			if (right < size && nums[right] > nums[max])
				max = right;
			if (max != i) {
				int temp = nums[i];
				nums[i] = nums[max];
				nums[max] = temp;
				heapAdjust(nums, max, size);
			}
		}
		
	}
	
}
