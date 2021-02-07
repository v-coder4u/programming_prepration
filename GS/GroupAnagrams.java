package gs;

import java.util.*;

public class GroupAnagrams {
	public List<List> groupAnagrams(String[] strs) {
		Map<Integer, List> hm = new HashMap<>();
		List<List> returnList = new ArrayList();

		for (String s : strs) {
			int returnHash = AnagramCheck(s);
			List<String> lt = hm.getOrDefault(returnHash, new ArrayList());
			lt.add(s);
			hm.put(returnHash, lt);
		}

		return new ArrayList(hm.values());

	}

	public int AnagramCheck(String s) {

		int[] count = new int[26];
		for (char ch : s.toCharArray())
			count[ch - 'a']++;
		return Arrays.hashCode(count);

	}
}



//public List<List<String>> groupAnagrams(String[] strs) {
//    List<List<String>> result = new ArrayList<>();
//    if (strs == null || strs.length == 0)
//        return result;
//    Map<String, List<String>> map = new HashMap<>();
//    for (String word:strs){
//        char[] chArr = word.toCharArray();
//        Arrays.sort(chArr);
//        String sorted = new String(chArr);
//        map.putIfAbsent(sorted, new ArrayList<String>());
//        map.get(sorted).add(word);
//    }
//    for(List l:map.values())
//        result.add(l);
//    return result;
//}