package google;

import java.util.*;

public class ChracterBag {
	public List<String> generate(HashMap<Character, Integer> bag, int len) {
		List<String> result = new ArrayList<>();
		List<String> result2 = new ArrayList<>();
		helper(result, "", bag, len);
		int[] characters = new int[128];
		for (Character c : bag.keySet())
			characters[c - 'a'] = bag.get(c);
		helper(result2, "", characters, 0, len);
		System.out.println(result);
		System.out.println(result2);
		return result;
	}

	private void helper(List<String> result, String str,
			HashMap<Character, Integer> bag, int len) {
		if (str.length() == len) {
			result.add(str);
			return;
		}
		for (char c : bag.keySet()) {
			if (bag.get(c) > 0) {
				bag.put(c, bag.get(c) - 1);
				helper(result, str + c, bag, len);
				bag.put(c, bag.get(c) + 1);
			}
		}
	}

	private void helper(List<String> result, String str, int[] arr, int index,
			int len) {
		if (str.length() == len) {
			result.add(str);
			return;
		}
		for (int i = index; i < arr.length; i++) {
			if (arr[i] > 0) {
				arr[i]--;
				helper(result, str + (char) (i + 'a'), arr, i, len);
				arr[i]++;
			}
		}
	}
	public static void main(String args[]){
		ChracterBag bag = new ChracterBag();
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('a', 2);
		map.put('b', 1);
		map.put('c', 2);
		bag.generate(map, 2);
	}
}
