package leetcode;

import java.util.*;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		int[] degree = new int[n];
		HashMap<Integer, List<Integer>> adjList = new HashMap<>();
		// form adjancy list
		for (int[] edge : edges) {
			degree[edge[0]]++;
			degree[edge[1]]++;
			if (!adjList.containsKey(edge[0])) {
				adjList.put(edge[0], new ArrayList<Integer>());
			}
			if (!adjList.containsKey(edge[1])) {
				adjList.put(edge[1], new ArrayList<Integer>());
			}
			adjList.get(edge[0]).add(edge[1]);
			adjList.get(edge[1]).add(edge[0]);
		}
		// using set to store the vertices
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(i);
		}
		// store all the leaf nodes in the list
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 1) {
				list.add(i);
			}
		}
		// remove until only two root left, each time remove all the leave nodes.
		while (set.size() > 2) {
			List<Integer> level = new ArrayList<>();
			for (int i : list) {
				for (int j : adjList.get(i)) {
					degree[j]--;
					// check if it becomes the new leaf nodes
					if (degree[j] == 1) {
						level.add(j);
					}
				}
				// remove leaf nodes in the set
				set.remove(i);
			}
			list = new ArrayList<>(level);
		}
		return new ArrayList<>(set);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumHeightTrees mht = new MinimumHeightTrees();
		int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		System.out.println(mht.findMinHeightTrees(4, edges));
	}

}
