import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class StringComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		if (o1.length() == 0 && o2.length() != 0) {
			return 1;
		} else if (o2.length() == 0 && o1.length() != 0) {
			return -1;
		} else if (o1.length() == 0 && o2.length() == 0) {
			return 0;
		}
		// TODO Auto-generated method stub
		if (o1.charAt(0) < o2.charAt(0)) {
			return -1;
		} else if (o1.charAt(0) > o2.charAt(0)) {
			return 1;
		} else {
			if (o1.length() < o2.length()) {
				if (o1.equals(o2.substring(0, o1.length()))) {
					if (o2.charAt(o1.length()) > o1.charAt(0)) {
						return -1;
					} else if (o2.charAt(o1.length()) < o1.charAt(0)) {
						return 1;
					} else {
						return compare(o1, o2.substring(o1.length()));
					}
				} else {
					return compare(o1, o2.substring(0, o1.length()));
				}

			} else if (o1.length() > o2.length()) {
				if (o2.equals(o1.substring(0, o2.length()))) {
					if (o1.charAt(o2.length()) > o2.charAt(0)) {
						return 1;
					} else if (o1.charAt(o2.length()) < o2.charAt(0)) {
						return -1;
					} else {
						return compare(o1.substring(o2.length()), o2);
					}
				} else {
					return compare(o1.substring(0, o2.length()), o2);
				}

			} else {
				return compare(o1.substring(1), o2.substring(1));
			}
		}
	}
}

public class LargestNumber {
	public String largestNumber(int[] num) {
		if (num.length == 0) {
			return "0";
		}
		ArrayList<String> list = new ArrayList();
		StringComparator sc = new StringComparator();
		for (int i : num) {
			list.add(Integer.valueOf(i).toString());
		}
		System.out.println(list);
		Collections.sort(list, sc);
		System.out.println(list);
		String result = "";
		for (int i = list.size() - 1; i >= 0; i--) {
			result += list.get(i);
		}
		if (result.charAt(0) == '0') {
			return "0";
		}
		return result;
	}

	public static void main(String args[]) {
		int[] num = { 9682, 928, 2354, 8060 };
		LargestNumber ln = new LargestNumber();
		System.out.println(ln.largestNumber(num));
	}

}