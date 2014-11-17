package leetcode;
import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String s) {
		// System.out.println(s);
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		hashMap.put('I', 1);
		hashMap.put('V', 5);
		hashMap.put('X', 10);
		hashMap.put('L', 50);
		hashMap.put('C', 100);
		hashMap.put('D', 500);
		hashMap.put('M', 1000);
		// System.out.println(hashMap);
		int len = s.length();
		Integer sum = 0;
		for (int i = 0; i < len - 1; i++) {
			Integer num = hashMap.get(s.charAt(i));
			Integer num2 = hashMap.get(s.charAt(i + 1));
			// System.out.println(num);
			// System.out.println(num2);
			if (num < num2) {
				num = num * (-1);
			}
			sum = sum + num;
		}
		sum = sum + hashMap.get(s.charAt(len - 1));
		// System.out.println(sum);
		return sum;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanToInteger roman = new RomanToInteger();
		System.out.println(roman.romanToInt("XXI"));
	}

}
