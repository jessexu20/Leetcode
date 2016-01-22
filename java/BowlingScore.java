package google;

public class BowlingScore {
	public int countBowling(String str) {
		String[] strings = str.split(",");
		int[] cnt = new int[10];
		int j = 0;
		boolean first = true;
		for (int i = 0; i < strings.length; i++) {
			if (strings[i].equals("X")) {
				cnt[j++] = 10 + bonus("X", i, strings);
				continue;
			}
			if (first) {
				cnt[j] = Integer.valueOf(strings[i]);
				first = false;
			} else {
				cnt[j] += Integer.valueOf(strings[i]);
				if (cnt[j] == 10) {
					cnt[j] += bonus("/", i, strings);
				}
				j++;
				first = true;
			}
		}
		int result = 0;
		for (int i : cnt) {
			System.out.print(i + "\t");
			result += i;
		}

		System.out.println();
		return result;
	}

	private int bonus(String str, int index, String[] strings) {
		int next = 0;
		if (index + 1 < strings.length) {
			next = strings[index + 1].equals("X") ? 10 : Integer
					.valueOf(strings[index + 1]);
		}
		int next2 = 0;
		if (index + 2 < strings.length) {
			next2 = strings[index + 2].equals("X") ? 10 : Integer
					.valueOf(strings[index + 2]);
		}
		System.out.println("" + index + "\t" + next + "\t" + next2);
		return str.equals("X") ? next + next2 : next;

	}

	public static void main(String args[]) {
		BowlingScore bowling = new BowlingScore();
		System.out.println(bowling
				.countBowling("X,9,1,X,1,2,4,4,9,0,3,5,X,X,1,2"));
	}
}
