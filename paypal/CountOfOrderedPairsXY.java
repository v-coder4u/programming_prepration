package paypal;

public class CountOfOrderedPairsXY {

	private static void solve(int n) {
		int ans = 0;

		// Iterate over all possible values of y
		for (int y = n + 1; y <= n * n + n; y++) {

			// For valid x and y,
			// (n*n)%(y - n) has to be 0
			if ((n * n) % (y - n) == 0) {

				// Increment count of ordered pairs
				ans += 1;
			}
		}
		System.out.print(ans);
	}

	public static void main(String[] args) {
		int n = 5;
		solve(n);
	}

}
