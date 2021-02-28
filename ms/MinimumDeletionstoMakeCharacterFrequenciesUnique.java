package ms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {

	public static int minDeletions2(String s) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
		Map<Character, Integer> map = new HashMap();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (char c : map.keySet())
			pq.add(map.get(c));

		int ans = 0;

		while (!pq.isEmpty() && pq.size() > 1) {
			int a = pq.poll();
			if (a == 0)
				continue;
			int b = pq.poll();
			if (b == 0) {
				pq.add(a);
				continue;
			}
			if (a == b) {
				pq.add(b - 1);
				pq.add(a);
				ans++;
			} else {
				pq.add(b);
			}
		}
		return ans;
	}

	public static int minDeletions(String s) {
		int deletions = 0;

		int[] letters = new int[26];

		for (char c : s.toCharArray()) {
			int index = c - 'a';
			letters[index]++;
		}

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < letters.length; i++) {
			while (letters[i] != 0 && !set.add(letters[i])) {
				letters[i]--;
				deletions++;
			}
		}

		return deletions;
	}

	public static void main(String[] args) {
		System.out.println(minDeletions("aab"));
		System.out.println(minDeletions2("aab"));
	}

}
