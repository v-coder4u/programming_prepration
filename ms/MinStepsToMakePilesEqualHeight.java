package ms;

public class MinStepsToMakePilesEqualHeight {

	public int minSteps(int[] piles) {
		int len = piles.length;
		if (len <= 1)
			return 0;
		Arrays.sort(piles);
		int res = 0, distinctNums = 0;
		for (int i = 1; i < len; ++i) {
			if (piles[i] == piles[i - 1]) {
				res += distinctNums;
			} else {
				++distinctNums;
				res += distinctNums;
			}
		}
		return res;
	}

	// sol2
	private static int minSteps(int[] piles) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int p : piles) {
			map.put(p, map.getOrDefault(p, 0) + 1);
		}
		Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
		maxHeap.addAll(map.entrySet());
		while (maxHeap.size() > 1) {
			Map.Entry<Integer, Integer> entry1 = maxHeap.poll();
			Map.Entry<Integer, Integer> entry2 = maxHeap.poll();
			res += entry1.getValue();
			entry2.setValue(entry2.getValue() + entry1.getValue());
			maxHeap.offer(entry2);
		}
		return res;
	}
}
