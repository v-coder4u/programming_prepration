package ms;

import java.util.Scanner;

public class DiceThrow {

	public static long findWays(int f, int d, int s) {
		long dp[][] = new long[d + 1][s + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= d; i++) {
			for (int j = i; j <= s; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
				if (j - f - 1 >= 0)
					dp[i][j] -= dp[i - 1][j - f - 1];
			}
		}
		return dp[d][s];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		int d = sc.nextInt();
		int s = sc.nextInt();
		System.out.println(findWays(f, d, s));
	}

}
