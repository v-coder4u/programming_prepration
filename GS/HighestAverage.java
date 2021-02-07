package gs;

import java.util.*;

public class HighestAverage {

	public int hishestAverage(String[][] scores) {
		if (scores == null || scores.length == 0) {
			return -1;
		}
		int highestAve = 0;
		Map<String, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < scores.length; i++) {
			List<Integer> scoreList = map.get(scores[i][0]);
			if (scoreList == null) {
				List<Integer> currentScore = new ArrayList<>();
				currentScore.add(Integer.valueOf(scores[i][1]));
				map.put(scores[i][0], currentScore);
			} else {
				scoreList.add(Integer.valueOf(scores[i][1]));
				map.put(scores[i][0], scoreList);
			}
		}

		// go through the map. find the largest ave
		for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
			int currentAveScore = aveCalculate(entry.getValue());

			highestAve = Math.max(highestAve, currentAveScore);
		}

		return highestAve;
	}

	private int aveCalculate(List<Integer> scores) {
		int len = scores.size();
		int sum = 0;
		for (int score : scores) {
			sum += score;
		}

		float ave = sum / len;
		return (int) ave;
	}
}




class HighestAverage2 {
	static String[][] data = new String[][] { { "Bob", "87" }, { "Mike", "35" }, { "Bob", "52" }, { "Jason", "35" },
			{ "Mike", "55" }, { "Jessica", "99" } };

	public static void main(String[] args) {
		System.out.println(getBestAverage());
	}

	private static int getBestAverage() {
		Map<String, int[]> map = new HashMap<>();
		int best = -1;
		for (String[] d : data) {
			String name = d[0];
			int score = Integer.parseInt(d[1]);
			if (!map.containsKey(name))
				map.put(name, new int[] { 1, score });
			else {
				map.get(name)[0]++;
				map.get(name)[1] += score;
			}
		}

		for (int[] score : map.values()) {
			best = Math.max(best, score[1] / score[0]);
		}
		return best;
	}
}


class MaximumStudentMarkAverage3 {
	static class Student {
		String name;
		int mark;
		int count;

		public Student(String name, int mark, int count) {
			this.name = name;
			this.mark = mark;
			this.count = count;
		}
	}

	public static void findMaxAverage(String[][] input) {
		Map<String, Student> map = new HashMap<>();
		int max = Integer.MIN_VALUE;

		for (String[] r : input) {
			if (map.containsKey(r[0])) {
				Student t = map.get(r[0]);
				map.put(r[0], new Student(r[0], t.mark + Integer.parseInt(r[1]), t.count + 1));
				max = Math.max((t.mark + Integer.parseInt(r[1])) / (t.count + 1), max);
			} else {
				map.put(r[0], new Student(r[0], Integer.parseInt(r[1]), 1));
				max = Math.max(Integer.parseInt(r[1]), max);
			}
		}
		System.out.println(max);
	}
}
