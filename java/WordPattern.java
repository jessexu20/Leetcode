/*Word Pattern
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.
*/
public class WordPattern {
	HashMap<Character, String> map = new HashMap();
	public boolean wordPatternMatch(String pattern, String str) {
		if (pattern.length() < 1) {
			return str.length() < 1;
		}
		char c = pattern.charAt(0);
		if (map.containsKey(c)) {
			if (!str.startsWith(map.get(c)))
				return false;
			if (wordPatternMatch(pattern.substring(1),
					str.substring(map.get(c).length())))
				return true;
		} else {
			for (int j = 1; j <= str.length(); j++) {
				if (map.containsValue(str.substring(0, j))) continue;
				map.put(c, str.substring(0, j));
				if (wordPatternMatch(pattern.substring(1), str.substring(j)))
					return true;
				else map.remove(c);

			}
		}

		return false;
	}
}