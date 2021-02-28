package ms;

public class FrogJump {

	public static void main(String[] args) {
		int[] b = new int[] { 1, 1 };

		int n = b.length;

		// r[i] is the rightmost block that can be reached from block i;
		int[] r = new int[n];

		// l[i] is the leftmost block that can be reached from block i;
		int[] l = new int[n];

		r[n - 1] = n - 1;
		for (int i = n - 2; i >= 0; i--) {
			r[i] = i;
			if (b[i + 1] >= b[i])
				r[i] = r[i + 1];
		}

		l[0] = 0;
		for (int i = 1; i < n; i++) {
			l[i] = i;
			if (b[i - 1] >= b[i])
				l[i] = l[i - 1];
		}

		int max = 1;
		for (int i = 0; i < n; i++) {
			max = Math.max(r[i] - l[i] + 1, max);
		}

		System.out.println(max);
	}

}
