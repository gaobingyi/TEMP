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
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int index = partition(array, low, high);
			quickSort(array, low, index-1);
			quickSort(array, index+1, high);
		}
	}

	private static int partition(int[] array, int low, int high) {
		int pivot = array[low]; // select the first element as pivot
		while (low < high) {
			while (low < high && array[high] >= pivot)
				high--;
			array[low] = array[high];
			while (low < high && array[low] <= pivot)
				low++;
			array[high] = array[low];
		}
		// now low is equal to high
		array[low] = pivot;
		return low;
	}
	
	/*
	 * Merge Sort
	 */
	public static void mergeSort(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
	}
	private static void mergeSort(int[] nums, int begin, int end) {
		if (begin < end) {
			int mid = (begin + end) / 2;
			mergeSort(nums, begin, mid);
			mergeSort(nums, mid+1, end);
			merge(nums, begin, mid, end);
		}
	}
	private static void merge(int[] nums, int begin, int mid, int end) {
		int[] temp = new int[nums.length];
		int i = begin;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= end)
			temp[k++] = (nums[i] < nums[j]) ? nums[i++] : nums[j++];
		while (i <= mid)
			temp[k++] = nums[i++];
		while (j <= end)
			temp[k++] = nums[j++];
		for (i = 0; i < k; i++)
			nums[begin+i] = temp[i];
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
