/*Reverse Words in a String II
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?

Related problem: Rotate Array


*/
public class ReverseWordsII {
    public void reverseWords(char[] s) {
        //reverse whole string and then reverse each words
        
        for(int i = 0; i < s.length/2; i++){
            swap(s,i,s.length-i-1);
        }
        int i = 0,j = 0;
        while(i < s.length && j < s.length){
            if(s[j]==' '){
                for(int k = 0;k<(j-i)/2;k++){
                    swap(s,i+k,j-1-k);
                }
                i=j+1;
            }
            j++;
        }
		// String t = new String(s);
		// System.out.println(i+"\t"+j+"\t"+t);
        if(i<s.length && j>=s.length){
            for(int k = 0;k<(j-i)/2;k++){
            	swap(s,i+k,j-1-k);
			}
        }
    }
    public void swap(char [] arr, int x, int y){
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}