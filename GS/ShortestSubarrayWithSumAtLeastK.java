package gs;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {

	public int shortestSubarray(int[] A, int K) {

		int n = A.length;
		int len = Integer.MAX_VALUE;

		int[] prefixSum = new int[n + 1];
		prefixSum[0] = 0;

		// Calculate the prefix sum
		for (int i = 1; i < n + 1; i++)
			prefixSum[i] = A[i - 1] + prefixSum[i - 1];

		Deque<Integer> dq = new ArrayDeque<>();

		// Maintain a monotone queue
		for (int i = 0; i < n + 1; i++) {

			while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= K) {
				len = Math.min(len, i - dq.peekFirst());
				dq.pollFirst();
			}

			while (!dq.isEmpty() && prefixSum[i] < prefixSum[dq.peekLast()]) {
				dq.pollLast();
			}

			dq.offer(i);
		}

		return len == Integer.MAX_VALUE ? -1 : len;
	}
}
