package gs;

import java.util.Arrays;

public class KnightProbablityInChessBoard {
	double[][][] dp;
	int N;

	public double knightProbability(int N, int K, int r, int c) {
		dp = new double[N][N][K + 1];
		this.N = N;
		return getProb(r, c, K);
	}

	private double getProb(int r, int c, int K) {

		// we're in an illegal state. we stop.
		// "The knight continues moving until it has made exactly K moves or has moved
		// off the chessboard."
		if (r < 0 || c < 0 || r >= N || c >= N)
			return 0.0;

		// No more moves left. If we're in a valid state, it contributes a value of 1,
		// if not, it contributes a value of 0.
		if (K == 0) {
			if (r < 0 || c < 0 || r >= N || c >= N)
				return 0.0;
			else
				return 1.0;
		}

		// memoization
		if (dp[r][c][K] != 0) {
			return dp[r][c][K];
		}

		// dp logic
		dp[r][c][K] = .125 * getProb(r - 2, c - 1, K - 1) + 
					  .125 * getProb(r - 2, c + 1, K - 1) + 
					  .125 * getProb(r - 1, c + 2, K - 1) + 
					  .125 * getProb(r + 1, c + 2, K - 1) + 
					  .125 * getProb(r + 2, c + 1, K - 1) + 
					  .125 * getProb(r + 2, c - 1, K - 1) + 
					  .125 * getProb(r + 1, c - 2, K - 1) + 
					  .125 * getProb(r - 1, c - 2, K - 1);

		return dp[r][c][K];
	}
}

//    double[][][] dp;
//
//	public double knightProbability(int N, int K, int r, int c) {
//		dp = new double[N][N][K + 1];
//		for (double[][] arr : dp)
//			for (double[] arr2 : arr)
//				Arrays.fill(arr2, -1.0);
//		return helper(N, K, r, c);
//	}
//
//	private double helper(int N, int k, int r, int c) {
//		if (k == 0)
//			return 1.0;
//		if (dp[r][c][k] != -1.0)
//			return dp[r][c][k];
//
//		// all 8 possible direction
//		double one = 0.0, two = 0.0, three = 0.0, four = 0.0, five = 0.0, six = 0.0, seven = 0.0, eight = 0.0;
//		if (isValid(r - 1, c - 2, N))
//			one = (1.0 / 8) * helper(N, k - 1, r - 1, c - 2);
//		if (isValid(r - 2, c - 1, N))
//			two = (1.0 / 8) * helper(N, k - 1, r - 2, c - 1);
//		if (isValid(r - 2, c + 1, N))
//			three = (1.0 / 8) * helper(N, k - 1, r - 2, c + 1);
//		if (isValid(r - 1, c + 2, N))
//			four = (1.0 / 8) * helper(N, k - 1, r - 1, c + 2);
//		if (isValid(r + 1, c + 2, N))
//			five = (1.0 / 8) * helper(N, k - 1, r + 1, c + 2);
//		if (isValid(r + 2, c + 1, N))
//			six = (1.0 / 8) * helper(N, k - 1, r + 2, c + 1);
//		if (isValid(r + 2, c - 1, N))
//			seven = (1.0 / 8) * helper(N, k - 1, r + 2, c - 1);
//		if (isValid(r + 1, c - 2, N))
//			eight = (1.0 / 8) * helper(N, k - 1, r + 1, c - 2);
//
//		return dp[r][c][k] = (one + two + three + four + five + six + seven + eight);
//	}
//
//	private boolean isValid(int r, int c, int N) {
//		if (r < 0 || r >= N || c < 0 || c >= N)
//			return false;
//		return true;
//	}
