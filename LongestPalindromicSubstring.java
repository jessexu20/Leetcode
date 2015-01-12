public class LongestPalindromicSubstring {
	public String match(String a, String b) {
		String resultString = "";
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				resultString += a.charAt(i);
			}
		}
		return resultString;
	}

	public String longestPalindrome(String s) {
		StringBuffer original = new StringBuffer(s);
		StringBuffer reverse = new StringBuffer(s).reverse();
		int length = s.length();
		int i = 1;
		int j = length;
		String result = "";
		while (i < length) {
			String o = original.substring(length - i, j);
			String r = reverse.substring(0, i);
			String temp = match(o, r);
			if (temp.length() > result.length()) {
				result = temp;
			}
			i++;
			// System.out.print("+"+'\t');
			// System.out.println(o);
			// System.out.print("-"+'\t');
			// System.out.println(r);
		}
		while (j > 0) {
			String o = original.substring(0, j);
			String r = reverse.substring(length - j, length);
			String temp = match(o, r);
			if (temp.length() > result.length()) {
				result = temp;
			}
			j--;
			// System.out.print("+"+'\t');
			// System.out.println(o);
			// System.out.print("-"+'\t');
			// System.out.println(r);
		}
		return result;
	}

	public static void main(String args[]) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("a"));
	}
}
