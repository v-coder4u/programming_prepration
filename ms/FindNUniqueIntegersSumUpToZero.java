package ms;

public class FindNUniqueIntegersSumUpToZero {

	public int[] sumZero(int n) {
		int seed = 1;
		int[] res = new int[n];
		for (int i = 0; i < n / 2; i++) {
			res[n - (1 + i)] = seed * -1;
			res[i] = seed++;
		}

		return res;
	}
}
