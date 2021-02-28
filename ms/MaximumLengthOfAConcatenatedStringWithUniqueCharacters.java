package ms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

	// backtracking + bit
	public int res = 0;
	public Map<String, Integer> map = new HashMap<>();

	public int maxLength(List<String> arr) {
		for (String str : arr) {
			int bit = 0;
			Set<Character> set = new HashSet<>();
			boolean check = true;
			for (char c : str.toCharArray()) {
				if (set.contains(c)) {
					check = false;
					break;
				}
				bit += (1 << (c - 'a'));
				set.add(c);
			}
			if (check)
				map.put(str, bit);
		}
		help(arr, 0, 0, 0);
		return res;
	}

	public void help(List<String> arr, int tot, int i, int len) {
		res = Math.max(res, len);
		for (int k = i; k < arr.size(); k++) {
			String str = arr.get(k);
			if (map.containsKey(str)) {
				int curBit = map.get(str);
				if ((curBit ^ tot) == curBit + tot) {
					help(arr, curBit + tot, k + 1, len + str.length());
				}
			}
		}
	}

	public static void main(String[] args) {

	}

	// ---------- only backtracking

	int maxLen = 0;

	public int maxLength2(List<String> arr) {
		backtracking(arr, 0, new StringBuilder(), new HashSet<Character>());
		return maxLen;
	}

	private void backtracking(List<String> arr, int start, StringBuilder sb, HashSet<Character> set) {
		if (sb.length() > maxLen)
			maxLen = sb.length();
		for (int i = start; i < arr.size(); i++) {
			boolean add = true;
			HashSet<Character> currSet = new HashSet<>();
			for (int j = 0; j < arr.get(i).length(); j++) {
				if (currSet.contains(arr.get(i).charAt(j)) || set.contains(arr.get(i).charAt(j)))
					add = false;
				currSet.add(arr.get(i).charAt(j));
			}
			if (add) {
				sb.append(arr.get(i));
				set.addAll(currSet);
				backtracking(arr, i + 1, new StringBuilder(sb), set);
				set.removeAll(currSet);
				sb.setLength(sb.length() - arr.get(i).length());
			}
		}
	}
}
