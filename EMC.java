import java.util.Arrays;

public class EMC {
	
	public static int[] maxAndMinDistance(String s, char c1, char c2) {
		if (s.indexOf(c1) == -1 || s.indexOf(c2) == -1)
			return new int[] {-1, -1};
		
		int maxDistance = 0;
		int minDistance = Integer.MAX_VALUE;
		
		// Max Distance
		int begin = 0;
		int end = s.length() - 1;
		while (begin < end && s.charAt(begin) != c1)
			begin++;
		while (begin < end && s.charAt(end) != c2)
			end--;
		maxDistance = Math.max(maxDistance, end - begin + 1);
		begin = 0;
		end = s.length() - 1;
		while (begin < end && s.charAt(begin) != c2)
			begin++;
		while (begin < end && s.charAt(end) != c1)
			end--;
		maxDistance = Math.max(maxDistance, end - begin + 1);
		
		// Min Distance
		begin = 0;
		end = s.length() - 1;
		while (begin < end && (s.charAt(begin) != c1 && s.charAt(begin) != c2))
			begin++;
		char nextFindChar = s.charAt(begin) == c1 ? c2 : c1;
		int lastFindIndex = begin;
		for (; begin < end; begin++) {
			while (begin < end && s.charAt(begin) != nextFindChar)
				begin++;
			minDistance = Math.min(minDistance, begin - lastFindIndex + 1);
			nextFindChar = s.charAt(begin) == c1 ? c2 : c1;
			lastFindIndex = begin;
		}
		
		return new int[] {maxDistance, minDistance};
	}
	
	public static void main(String[] args) {
		String s = "aaxbcaxbbxad";
		char c1 = 'a';
		char c2 = 'b';
		System.out.println(Arrays.toString(maxAndMinDistance(s, c1, c2)));
	}

}
