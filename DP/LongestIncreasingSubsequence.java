package dp;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int totalMax = 0;
		for (int i = 0; i < dp.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[j] > max) {
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			if (dp[i] > totalMax) {
				totalMax = dp[i];
			}
		}
		return totalMax;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfElements = sc.nextInt();
		int[] nums = new int[numberOfElements];
		for (int i = 0; i < numberOfElements; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println("Max LIS is: " + lengthOfLIS(nums));
	}
}
