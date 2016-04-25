import java.util.ArrayList;
/*
For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/
public class DecodeWays{
    public int numDecodings(String s) {
        if(s.length()<1 || s.charAt(0)=='0') return 0;
        if(s.length()==1) return 1;
        int [] dp =new int [s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=s.length();i++){
            int number=Integer.parseInt(s.substring(i-2,i));
            int twoStep= (number<=26 && number>=10)? dp[i-2]:0;//to get rid of 02,03 
            int oneStep= (Integer.parseInt(s.substring(i-1,i))>0)? dp[i-1]:0;//to get rid of 2,0,20
            dp[i]=twoStep+oneStep;
        }
        return dp[s.length()];
    }
	public static void main(String args[]){
		DecodeWays dw=new DecodeWays();
		String str="12";
		System.out.println(dw.numDecodings(str));
	}
}