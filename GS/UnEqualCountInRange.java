package gs;

public class UnEqualCountInRange {

	static int countInRange(int l, int r, int q) {
		int count = 0;
		for (int i = l; i <= r; i++) {
			if (checkIfUnequal(i, q))
				count++;
		}
		return count;
	}

	static boolean checkIfUnequal(int n, int q) {
		String s1 = Integer.toString(n);
		int a[] = new int[26];
		for (int i = 0; i < s1.length(); i++)
			a[s1.charAt(i) - '0']++;

		int prod = n * q;
		String s2 = Integer.toString(prod);

		for (int i = 0; i < s2.length(); i++) {
			if (a[s2.charAt(i) - '0'] > 0)
				return false;
		}
		return true;
	}
}
