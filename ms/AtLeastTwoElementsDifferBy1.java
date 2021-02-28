package ms;

public class AtLeastTwoElementsDifferBy1 {

	private static boolean solve(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int n : nums) {
			if(set.contains(n-1) || set.contains(n+1))
				return true;
			set.add(n);
		}
		return false;
	}
}
