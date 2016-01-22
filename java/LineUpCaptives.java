/*
Line up the captives
====================

As you ponder sneaky strategies for assisting with the great rabbit escape, you realize that you have an opportunity to fool Professor Booleans guards into thinking there are fewer rabbits total than there actually are.

By cleverly lining up the rabbits of different heights, you can obscure the sudden departure of some of the captives.

Beta Rabbits statisticians have asked you for some numerical analysis of how this could be done so that they can explore the best options.

Luckily, every rabbit has a slightly different height, and the guards are lazy and few in number. Only one guard is stationed at each end of the rabbit line-up as they survey their captive population. With a bit of misinformation added to the facility roster, you can make the guards think there are different numbers of rabbits in holding.

To help plan this caper you need to calculate how many ways the rabbits can be lined up such that a viewer on one end sees x rabbits, and a viewer on the other end sees y rabbits, because some taller rabbits block the view of the shorter ones.

For example, if the rabbits were arranged in line with heights 30 cm, 10 cm, 50 cm, 40 cm, and then 20 cm, a guard looking from the left side would see 2 rabbits (30 and 50 cm) while a guard looking from the right side would see 3 rabbits (20, 40 and 50 cm). 

Write a method answer(x,y,n) which returns the number of possible ways to arrange n rabbits of unique heights along an east to west line, so that only x are visible from the west, and only y are visible from the east. The return value must be a string representing the number in base 10.

If there is no possible arrangement, return "0".

The number of rabbits (n) will be as small as 3 or as large as 40
The viewable rabbits from either side (x and y) will be as small as 1 and as large as the total number of rabbits (n).

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (int) x = 2
    (int) y = 2
    (int) n = 3
Output:
    (string) "2"

Inputs:
    (int) x = 1
    (int) y = 2
    (int) n = 6
Output:
    (string) "24"
*/
package google;

import java.util.*;
import java.math.*;

public class LineUpCaptives {
	static HashMap<Integer, HashMap<Integer,BigInteger>> cache = new HashMap<>();
	static HashMap<Integer, BigInteger> factorial = new HashMap<>();
	public static String answer(int x, int y, int n) {
		// Your code goes here.
		BigInteger cnt = BigInteger.ZERO;
		for (int pos = x-1; pos < n-y-1; pos++) {
			int numRabbitsX = pos;
            int numRabbitsY = n - pos - 1;
            //from x side, anything behind pos is not visible
			BigInteger xPermutations = permutate(x - 1, numRabbitsX);
			//from y side, anything before pos is not visible
			//so the only one can be seen is pos.
            BigInteger yPermutations = permutate(y - 1, numRabbitsY);
            //pick the numofx of the rest of the side to fill in the left blanks
            BigInteger combinations = combinations(n - 1, numRabbitsX);
            cnt = cnt.add(xPermutations.multiply(yPermutations).multiply(combinations));
		}
		return cnt.toString();

	}
	static BigInteger permutate(int numVisible, int numRabbits){
		if(cache.containsKey(numRabbits)){
			if (cache.get(numRabbits).containsKey(numVisible)) {
				return cache.get(numRabbits).get(numVisible);
			}
		}
		if (numVisible>=numRabbits) {
			return numVisible == numRabbits? BigInteger.ONE:BigInteger.ZERO;
		}
		BigInteger cnt = BigInteger.ZERO;
		//assume rabbits is sorted in ascending order
		for (int pos = 0; pos < numRabbits; pos++) {
			int left = pos;
			int right = numRabbits - pos - 1;
			//pick "left" number to fill in the left blanks.
			BigInteger leftPickerNumbers = combinations(numRabbits-1, left);
			//go to next level, use the picked number
			BigInteger combineLeft = permutate(numVisible-1, left);
			//pick "right" number to fill in the right blanks, and do a Pn, since on the right, any seq is okay
			BigInteger combineRight = calFactorial(right);
			//calculate the left*leftcombine + rightcombine
			cnt = cnt.add(leftPickerNumbers.multiply(combineLeft).multiply(combineRight));
		}
		if (!cache.containsKey(numRabbits)) {
			cache.put(numRabbits, new HashMap<Integer,BigInteger>());
		}
		cache.get(numRabbits).put(numVisible, cnt);
		return cnt;
		
	}
	static BigInteger combinations(int n, int x){
		//return xCn
		BigInteger total = calFactorial(n);
		BigInteger picked = calFactorial(x);
		BigInteger notPicked = calFactorial(n-x);
		return total.divide(picked.multiply(notPicked));
	}
	static BigInteger calFactorial(int num) {
		// return num!
		
		if (!factorial.containsKey(num)) {
			BigInteger result = BigInteger.ONE;
			for (int i = 2; i <= num; i++) {
				result = result.multiply(BigInteger.valueOf(i));
			}
			factorial.put(num, result);
		}

		return factorial.get(num);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LineUpCaptives.answer(1, 2, 6));
	}

}
