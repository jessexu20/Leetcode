package leetcode;

public class StrStr {
	public int strStr(String haystack, String needle) {
		int i = 0, j = 0, k = 0;
		while (k < haystack.length()) {
			i = k;
			while (j < needle.length() && i < haystack.length()) {
				if (haystack.charAt(i) == needle.charAt(j)) {
					i++;
					j++;
				} else {
					break;
				}
			}
			if (j == needle.length()) {
				break;
			} else {
				j = 0;
			}
			k++;
			if (k > haystack.length() - needle.length()) {
				return -1;
			}
		}
		if (k > haystack.length() - needle.length()) {
			return -1;
		} else
			return k;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "PPoinPPPoint";
		String b = "Point";
		StrStr str = new StrStr();
		System.out.println(str.strStr(a, b));
	}

}
