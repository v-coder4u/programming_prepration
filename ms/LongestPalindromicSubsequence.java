package ms;

import java.util.Scanner;

public class LongestPalindromicSubsequence {

	static int max(int x, int y) {
		return (x > y) ? x : y;
	}

	static int lps(String seq) {
		int n = seq.length();
		int i, j, cl;
		int L[][] = new int[n][n];

		for (i = 0; i < n; i++)
			L[i][i] = 1;

		for (cl = 2; cl <= n; cl++) {
			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1;
				if (seq.charAt(i) == seq.charAt(j) && cl == 2)
					L[i][j] = 2;
				else if (seq.charAt(i) == seq.charAt(j))
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = max(L[i][j - 1], L[i + 1][j]);
			}
		}

		return L[0][n - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sequence = sc.next();
		System.out.println("The length of the lps is " + lps(sequence));
	}

}
