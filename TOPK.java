import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TOPK {
	
	private static int partition(int[] nums, int low, int high) {
		int pivot = nums[low]; // select the first element as pivot
		while (low < high) {
			while (low < high && nums[high] <= pivot)
				high--;
			nums[low] = nums[high];
			while (low < high && nums[low] >= pivot)
				low++;
			nums[high] = nums[low];
		}
		// now low is equal to high
		nums[low] = pivot;
		return low;
	}
	
	private int maxK(int[] nums, int low, int high, int k) {		
		int pivot = partition(nums, low, high);
		if (pivot > k - 1) {
			return maxK(nums , low, pivot-1, k);
		} else if (pivot < k - 1) {
			return maxK(nums , pivot+1, high, k-pivot+1);
		} else {
			return nums[pivot];
		}
	}
	
	public int maxK(int[] nums, int k) {
		return maxK(nums, 0, nums.length - 1, k);
	}
	
	public static void main(String[] args) {
		/*int nums[] = {3,5,8,4,2};
		int num = new TOPK().maxK(nums, 1);
		System.out.println(num);*/
		
		
		/*Queue<Integer> queue = new PriorityQueue<>(); // 默认是小根堆
		queue.add(2);
		queue.add(1);
		queue.add(3);
		while (!queue.isEmpty())
			System.out.println(queue.poll());
		
		Queue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -(o1 - o2);
			}		
		}); // 大根堆
		queue2.add(2);
		queue2.add(1);
		queue2.add(3);
		while (!queue2.isEmpty())
			System.out.println(queue2.poll());*/
		
		
		int nums[] = {3,5,8,4,2};
		int k = 5;
		int key = new TOPK().maxK(nums, k);
		int key2 = new TOPK().maxK2(nums, k);
		System.out.println(key + ", " + key2);
		
		
	}
	
	/*
	 * 查找数组中第k(0<k<=n)大的元素
	 */
	public int maxK2(int[] nums, int k) {
		if (k > nums.length)
			throw new RuntimeException("k must be less than the length of nums");
		Queue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			queue.add(nums[i]);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] > queue.peek()) {
				queue.poll();
				queue.add(nums[i]);
			}
		}
		return queue.peek();
	}
	
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
			if (p2 != null)
				p2 = p2.next;
		}
        while (p2 != null) {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        /*if (p1.next != null) {
        	p1.val = p1.next.val;
            p1.next = p1.next.next;
        } else {
        	ListNode p = head;
        	while (p.next.next != null)
        		p = p.next;
        	p.next = null;
        }
        return head;*/
        
        return removeNode(head, p1);
    }
	
	public ListNode removeNode(ListNode head, ListNode node) {
		ListNode p = head;
		while (p != null && p != node)
			p = p.next;
		if (p == null) 
			return head;
		if (p.next != null) {
			p.val = p.next.val;
            p.next = p.next.next;
		} else {
			ListNode p1 = head;
        	while (p1.next.next != null)
        		p1 = p1.next;
        	p1.next = null;
		}
		return head;	
	}
	
	List<List<Integer>> paths = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
        	return paths;
        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null)
        	paths.add(new ArrayList<Integer>(path));
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        path.remove(path.size() - 1);
        return paths;
    }
	
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x;
	}
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int x) { 
		val = x; 
	}
}
