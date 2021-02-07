package gs;

import java.util.Arrays;

public class MinimumFallingPathSum {
	public int minFallingPathSum(int[][] A) {
		int[][] dp = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			dp[0][i] = A[0][i];
		}
		for (int i = 1; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (j == 0) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
				} else if (j == A[0].length - 1) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + A[i][j];
				}
			}
		}
		int[] result = dp[dp.length - 1];
		Arrays.sort(result);
		return result[0];
	}
}






class solution2 {
	public static int[][] dp;

	public int minFallingPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		dp = new int[m + 1][n + 1];
		int path_sum = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			int min = dfsUtil(grid, 0, j, m, n);
			path_sum = Math.min(min, path_sum);
		}

		return path_sum;
	}

	public int dfsUtil(int[][] grid, int i, int j, int m, int n) {

		if (i == m)
			return 0;

		if (j < 0 || j >= n)
			return Integer.MAX_VALUE;

		if (dp[i][j] != 0) // check if value is already present or not.
			return dp[i][j];

		int sum1 = dfsUtil(grid, i + 1, j, m, n);
		int sum2 = dfsUtil(grid, i + 1, j - 1, m, n);
		int sum3 = dfsUtil(grid, i + 1, j + 1, m, n);
		dp[i][j] = Math.min(sum1, Math.min(sum2, sum3)) + grid[i][j]; // store the newly computed value in the DP table.

		return Math.min(sum1, Math.min(sum2, sum3)) + grid[i][j];
	}
}