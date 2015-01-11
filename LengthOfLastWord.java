package Leetcode;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
    	s=s.trim();
    	int len=s.length();
    	if (len==0)
    		return 0;
    	int i=0;
    	for(i=len-1;i>0;i--){
    		if (s.charAt(i)==' ')
    			break;
    	}  	
    	if (i>0)
    		return len-i-1;
    	else {
			return len-i;
		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthOfLastWord lastWord=new LengthOfLastWord();
		lastWord.lengthOfLastWord("heelo");
	}

}
