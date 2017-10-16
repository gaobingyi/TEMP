import java.util.Arrays;
import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		// Input matrix
		Scanner in = new Scanner(System.in);
		String[] rc = in.nextLine().split(" ");
		int row = Integer.valueOf(rc[0]);
		int col = Integer.valueOf(rc[1]);
		int[][] matrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			String[] nums = in.nextLine().split(" ");
			for (int j = 0; j < col; j++) {
				matrix[i][j] = Integer.valueOf(nums[j]);
			}
		}
		in.close();
		// Print matrix
		printMatrix(matrix, row, col);
	}
	
	public static void printMatrix(int[][] matrix, int row, int col) {
		for (int i = 0; i < row + col - 1; i++) {
        	for (int j = 0; j <= i; j++) {
	        	int k = i - j;
	        	if (j < row && k < col)
	        		System.out.println(matrix[j][k]);
        	}                        
        }
	}
	
	public static int foo2(int[] arr) {
		Arrays.sort(arr);	
		return arr[(arr.length - 1) / 2 + 1];
	}
	
	public static void foo4(int[] arr, int n) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			if (arr[low] + arr[high] < n) {
				low++;
			} else if (arr[low] + arr[high] > n) {
				high--;
			} else {
				System.out.println(arr[low] + " " + arr[high]);
				break;
			}
		}
	}

}
