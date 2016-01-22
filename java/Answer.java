package com.google.challenges; 

public class Answer {   
    // public static int answer(int n) {
    //     int [] dp = new int [n+1];
    //     dp[0] = 0;
    //     if(n==0)
    //         return 0;
    //     dp[1] = 1;
    //     for(int i = 2; i <= n; i++){
    //         int num = i;
    //         for(int j = 1; j * j <=i;j++){
    //             num = Math.min(num, dp[i - j*j]+1);
    //         }
    //         dp[i] = num;
    //     }
    //     return dp[n];
    //     // Your code goes here.
    //
    // }
	public static void main(String args[]){
		Answer ans = new Answer();
		int [] digest = {0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165};
		int [] result = ans.answer(digest);
		for (int i : result)
			System.out.print(i+"\t");
	}
	// Hash it out
	// ===========
	//
	// Something horrible must have gone wrong in that last mission. As you wake in a holding cell, you realize that youre in the clutches of Professor Booleans numerous but relatively incompetent minions! Time to plan another escape.
	//
	// Lucky for you nobody is around (do these security minions just sleep all the time?), so you have a chance to examine your cell. Looking around, you see no signs of surveillance (ha, they must underestimate you already) and the only thing keeping you contained is an electronic door lock. Should be easy enough.
	//
	// You and Beta Rabbit worked together to exfiltrate some of Professor Booleans security information in anticipation of a moment just like this one. Time to put it to the test.
	//
	// If memory serves, this locking mechanism relies on a horribly bad cryptographic hash, and you should be able to break it with some rudimentary calculations.
	//
	// To open these doors, you will need to reverse engineer the hash function it is using. You already managed to steal the details of the algorithm used, and with some quiet observation of the guards you find out the results of the hash (the digest). Now to break it.
	//
	// The function takes a 16 byte input and gives a 16 byte output. It uses multiplication (*), bit-wise exclusive OR (XOR) and modulo (%) to calculate an element of the digest based on elements of the input message:
	//
	// digest [i] = ( (129 * message[i]) XOR message[i-1]) % 256
	//
	// For the first element, the value of message[-1] is 0.
	//
	// For example, if message[0] - 1 and message[1] = 129, then:
	// For digest[0]:
	// 129*message[0] = 129
	// 129 XOR message[-1] = 129
	// 129 % 256 = 129
	// Thus digest[0] = 129.
	//
	// For digest[1]:
	// 129*message[1] = 16641
	// 16641 XOR message[0] = 16640
	// 16640 % 256 = 0
	// Thus digest[1] = 0.
	//
	// Write a function answer(digest) that takes an array of 16 integers and returns another array of 16 that correspond to the unique message that created this digest. Since each value is a single byte, the values are 0 to 255 for both message and digest.
	//
	// Languages
	// =========
	//
	// To provide a Python solution, edit solution.py
	// To provide a Java solution, edit solution.java
	//
	// Test cases
	// ==========
	//
	// Inputs:
	//     (int list) digest = [0, 129, 3, 129, 7, 129, 3, 129, 15, 129, 3, 129, 7, 129, 3, 129]
	// Output:
	//     (int list) [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
	//
	// Inputs:
	//     (int list) digest = [0, 129, 5, 141, 25, 137, 61, 149, 113, 145, 53, 157, 233, 185, 109, 165]
	// Output:
	//     (int list) [0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225]
    public static int[] answer(int[] digest) { 
		int [] result = new int [digest.length];
		if(digest.length == 0)
			return result;
		for(int i = 0; i < digest.length; i++){
			//digest [i] = ( (129 * message[i]) XOR message[i-1]) % 256
			for(int j = 0; j < 256; j++){
				int t = 0;
				if(i==0)
					t = ((129 * j) ^ 0) % 256;
				else 
					t = ((129 * j) ^ result[i-1]) % 256;
				if(t == digest[i]){
					result[i] = j;
					break;
				}
			}
		}
		return result;
           // Your code goes here.

    } 
}