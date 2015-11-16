/*
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].

Hint:

If a palindromic permutation exists, we just need to generate the first half of the string.
To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation
*/


import java.util.*;

public class PalindromePermutation {
	public List<String> generatePalindromes(String s) {
		HashMap<Character, Integer> map = new HashMap();
		List<String> result = new ArrayList();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		int cnt = 0;
		char single = ' ';
		for (Character c : map.keySet()) {//check if valid
			if (map.get(c) % 2 != 0) {
				cnt++;
				single = c;
			}
			if (cnt >= 2)
				return result;//not valid
		}
		String temp = "";
		if (cnt == 1) {
			temp += single;//append single value
			map.put(single, map.get(single) - 1);//modify occurance of single value
		}
		List<Character> chars = new ArrayList();
		for (Character c : map.keySet()) {
			chars.add(c);
		}
		if (temp.length()==0) {
			helper(result, map, chars, temp, s.length());
		}
		else helper(result, map, chars, temp, s.length()-1);//odd string
		
		return result;

	}

	public void helper(List<String> result, HashMap<Character, Integer> map,
			List<Character> chars, String temp, int len) {
		if (len==0) {
			result.add(temp);
			return;
		}
		for (int i = 0; i < chars.size(); i++) {
			char c = chars.get(i);
			if (map.get(c) > 0) {
				map.put(c, map.get(c) - 2);//remove 2 occurance
				helper(result, map, chars, c + temp + c, len - 2);
				map.put(c, map.get(c) + 2);//put back
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePermutation permutation = new PalindromePermutation();
		System.out.println(permutation.generatePalindromes("acc"));
	}

}
