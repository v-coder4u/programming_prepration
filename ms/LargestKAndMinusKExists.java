package ms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestKAndMinusKExists {
	private static int largestNum(int[] nums) {
		int res = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(-nums[i]);
			if (set.contains(nums[i])) {
				res = Math.max(res, Math.abs(nums[i]));
			}
		}
		return res;
	}

	private static int largestNum2(int[] nums) {
		int res = 0;
		Arrays.sort(nums);
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int sum = nums[l] + nums[r];
			if (sum == 0) {
				res = Math.max(res, Math.max(nums[l], nums[r]));
				l++;
				r--;
			} else if (sum < 0) {
				l++;
			} else {
				r--;
			}
		}
		return res;
	}
}
