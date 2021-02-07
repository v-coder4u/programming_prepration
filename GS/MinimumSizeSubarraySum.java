package gs;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int count = 0;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0, j = 0; j < nums.length; j++) {
			count += nums[j];
			while (i <= j && count >= s) {
				minLen = Math.min(minLen, j - i + 1);
				count -= nums[i];
				i++;
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}
