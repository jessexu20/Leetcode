import java.util.*;

class NewString implements Comparable<NewString> {
	String str;
	static String[] orderMap;

	NewString(String string) {
		str = string;
	}

	public int[] getOrder(String s) {
		int[] result = new int[2];
		for (int i = 0; i < orderMap.length; i++) {
			if (orderMap[i].startsWith(s)) {
				result[0] = i;
				result[1] = orderMap[i].length();
				return result;
			}
		}
		result[0] = -1;
		result[1] = 0;
		return result;
	}

	@Override
	public int compareTo(NewString o) {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		while (i < str.length() && i < o.str.length()) {
			String sub1 = str.substring(i, i + 1);
			String sub2 = o.str.substring(j, j + 1);
			int[] order1 = getOrder(sub1);
			int[] order2 = getOrder(sub2);
			if (order1[0] == -1 || order2[0] == -1) {
				return 1;
			}
			i += order1[1];
			j += order2[1];
			if (sub1.equals(sub2))
				continue;
			else {
				return order1[0] - order2[0];
			}
		}
		if (i == str.length() && i == o.str.length()) {
			return 0;
		} else {
			return i < str.length() ? 1 : -1;
		}
	}

	public static void setOrder(String[] order) {
		// TODO Auto-generated method stub
		orderMap = order;
	}

}

public class NewOrder {
	String[] order = { "a", "b", "ch", "d" };

	public void sortWord(String[] words) {
		NewString.setOrder(order);
		List<String> list = new ArrayList<>();
		Queue<NewString> que = new PriorityQueue<NewString>();
		for (int i = 0; i < words.length; i++) {
			NewString newString = new NewString(words[i]);
			que.add(newString);
		}
		while (!que.isEmpty()) {
			list.add(que.poll().str);
		}
		System.out.println(list);
	}

	public static void main(String args[]) {
		NewOrder newOrder = new NewOrder();
		String[] words = { "abch","achb","abd", "chba", "bch", "ach", "bb" };
		newOrder.sortWord(words);
	}
}