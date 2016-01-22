/*Strobogrammatic Number II
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
*/
/*Strobogrammatic Number III
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

For example,
Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are represented as string.
*/

import java.util.*;
public class StrobogrammaticNumberII {
	private int count;
	public List<String> findStrobogrammatic(int n) {
	    return helper(n, n);
	}

	List<String> helper(int n, int m) {
	    if (n == 0) return new ArrayList<String>(Arrays.asList(""));
	    if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

	    List<String> list = helper(n - 2, m);

	    List<String> res = new ArrayList<String>();

	    for (int i = 0; i < list.size(); i++) {
	        String s = list.get(i);

	        if (n != m) res.add("0" + s + "0");

	        res.add("1" + s + "1");
	        res.add("6" + s + "9");
	        res.add("8" + s + "8");
	        res.add("9" + s + "6");
	    }

	    return res;
	}
	public int strobogrammaticInRange(String low, String high) {
        count = 0;
    
        for (int i = low.length(); i <= high.length() ; i++) {
            if (i % 2 == 0) {
                strobogrammaticInRangeHelper(low, high, i, "");
            } else {
                strobogrammaticInRangeHelper(low, high, i-1, "0");
                strobogrammaticInRangeHelper(low, high, i-1, "1");
                strobogrammaticInRangeHelper(low, high, i-1, "8");
            }
        }
    
        return count;
    }
    
    private void strobogrammaticInRangeHelper(String low, String high, int n, String cur) {
        if (n == 0) {
            if ((cur.length() == low.length() && cur.compareTo(low) < 0) || 
                    (cur.length() == high.length() && cur.compareTo(high) > 0))
                return;
        
            count++;
            return;
        }
    
        if (n > 2) strobogrammaticInRangeHelper(low, high, n-2, '0'+cur+'0');
        strobogrammaticInRangeHelper(low, high, n-2, '1'+cur+'1');
        strobogrammaticInRangeHelper(low, high, n-2, '8'+cur+'8');
        strobogrammaticInRangeHelper(low, high, n-2, '6'+cur+'9');
        strobogrammaticInRangeHelper(low, high, n-2, '9'+cur+'6');
    }
	public static void main(String args[]){
		StrobogrammaticNumberII sn = new StrobogrammaticNumberII();
		System.out.println(sn.findStrobogrammatic(3));
	}
}