import java.util.*;
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
		int lenT=t.length();
		int lenS=s.length();
		int [][] dp=new int [lenS+1][lenT+1];
		for(int i=0;i<lenT+1;i++){
			dp[0][i]=0;
		}
		for(int i=0;i<lenS+1;i++){
			dp[i][0]=1;
		}

		for(int i=1;i<lenS+1;i++){
			for(int j=1;j<lenT+1;j++){
				if(s.charAt(i-1)==t.charAt(j-1)){
					dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
				}
				else{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		// for(int i=0;i<lenS+1;i++){
		// 	for(int j =0;j<lenT+1;j++){
		// 		System.out.print(dp[i][j]+"\t");
		// 	}
		// 	System.out.println();
		// }
		return dp[lenS][lenT];
    }
	public static void main(String args[]){
		DistinctSubsequences ds= new DistinctSubsequences();
		System.out.println(ds.numDistinct("rabbbit","rabbit"));
	}
}