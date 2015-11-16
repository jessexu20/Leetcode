/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

Note:
The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm

*/

import java.util.*;
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String ret="";
        if(strs.size()<1) return ret;
        for(String s : strs){
            ret=ret+String.valueOf(s.length())+"/"+ s;
        }
        return ret;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int index=-1;
        List<String> recover= new ArrayList<String>();
        int prev=0;
        for(int i=-1; i < s.length() && (i=s.indexOf("/",i+1))>0 ;){
            int len=Integer.valueOf(s.substring(prev,i));
            recover.add(s.substring(i+1,i+1+len));
            i+=len;
            prev=i+1;
        } 
        return recover;
    }
	public static void main(String args[]){
		Codec codec = new Codec();
		List<String> list= new ArrayList<String>();
		list.add("fT,NH8E&E /$ny[Wq,");list.add("2/31/311");list.add("");
		String encoded=codec.encode(list);
		System.out.println(encoded);
		System.out.println(codec.decode(encoded));
		
	}
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));