package paypal;

import java.util.*;

public class SocialMediaConnections {

	public static int getMinScore(int products_nodes, int products_edges, int[] products_from, int[] products_to) {
		HashMap<Integer, Set<Integer>> graph = new HashMap();
		int minProductSum = Integer.MAX_VALUE;
		for (int i = 0; i < products_edges; i++) {
			int from = products_from[i];
			int to = products_to[i];
			graph.computeIfAbsent(from, k -> new HashSet<Integer>()).add(to);
			graph.computeIfAbsent(to, k -> new HashSet<Integer>()).add(from);
		}

		for (int node : graph.keySet()) {
			Set<Integer> neis = graph.get(node);
			if (neis.size() < 2)
				continue;
			for (int nei1 : neis) {
				Set<Integer> nei2s = graph.get(nei1);
				Set<Integer> nei3s = findSharedNeighbors(neis, nei2s);
				for (int nei3 : nei3s) {
					int productSum = neis.size() + nei2s.size() + graph.get(nei3).size() - 6;
					minProductSum = Math.min(minProductSum, productSum);
				}
			}
		}

		return minProductSum == Integer.MAX_VALUE ? -1 : minProductSum;

	}

	public static Set<Integer> findSharedNeighbors(Set<Integer> l1, Set<Integer> l2) {
		Set<Integer> res = new HashSet();
		for (int node : l1) {
			if (l2.contains(node)) {
				res.add(node);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int friend_nodes = 6;
		int friend_edges = 6;
		int[] friends_from = new int[] { 1, 2, 2, 3, 4, 5 };
		int[] friends_to = new int[] { 2, 4, 5, 5, 5, 6 };
		System.out.println(getMinScore(friend_nodes, friend_edges, friends_from, friends_to));

	}

}
