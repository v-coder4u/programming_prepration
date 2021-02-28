package ms;

import java.util.Scanner;

public class NumberOfWaysToSplitAString {

	public static int numWays(String s) {
		int ones = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				ones++;
		}
		if (ones % 3 != 0)
			return 0;
		int mod = 1000000007;
		if (ones == 0) {
			long x = s.length() - 1;
			x = (x * (x - 1) / 2) % mod;
			return (int) x;
		}
		long res = 0L, c = 0;
		int onethird = ones / 3, twothird = 2 * onethird;
		ones = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1')
				ones++;
			if (ones == onethird)
				c++;
			if (ones == twothird)
				res = (res + c) % mod;
		}
		return (int) res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String value = sc.next();
		System.out.println(numWays(value));
	}

}
