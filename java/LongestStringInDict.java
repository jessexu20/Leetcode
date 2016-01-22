package google;

import java.util.*;

public class LongestStringInDict {

	// 1 filter. delete anything that is longer than the word.
	// 2 filter. delete anything has more characters than the word.
	// 3 delete single character in the string using queue(bfs) and match the
	// dict

	public Set<String> findLargestWord(String str, Set<String> dict) {
		Set<String> result = new HashSet<>();
		if (dict.contains(str)) {
			result.add(str);
			return result;
		}
		Set<String> filter = new HashSet<>();

		int[] count = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			count[c - 'a']++;
		}
		for (String s : dict) {
			if (s.length() <= str.length() && check(count.clone(), s))
				filter.add(s);
		}
		Queue<String> que = new LinkedList<>();

		que.offer(str);
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				String cur = que.poll();
				for (int j = 0; j < cur.length(); j++) {
					String next = cur.substring(0, j) + cur.substring(j + 1);
					if (filter.contains(next)) {
						result.add(next);
					} else
						que.offer(next);
				}
			}
			if (result.size() != 0)
				break;
		}
		return result;

	}

	private boolean check(int[] cnt, String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (--cnt[c - 'a'] < 0)
				return false;
		}
		return true;
	}
	public static void main(String args[]){
		LongestStringInDict test = new LongestStringInDict();
		Set<String> set =new HashSet<>();
		set.add("apple");
		set.add("ale");
		System.out.println(test.findLargestWord("appple", set));
		
	}
}
