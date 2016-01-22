public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int length1=s.length();
		int length2=p.length();
		boolean [][]dp= new boolean[length1+1][length2+1];
		dp[0][0]=true;
		for(int i=1;i<=length1;i++){
			dp[i][0]=false;
		}
		for(int i=1;i<=length2;i++){
			if(i>1 && dp[0][i-2] && p.charAt(i-1)=='*')
				dp[0][i]=true;
		}
		for(int i=1;i<=length1;i++){
			for(int j=1;j<=length2;j++){
				if(p.charAt(j-1)=='*'){
					dp[i][j]=((j>1)&&dp[i][j-2]) //when star * doesn't consume any chars in s
						||(j>1 && dp[i-1][j]&& (s.charAt(i-1)==p.charAt(j-2)|| p.charAt(j-2)=='.'));//when star * consume at lease one char in s
				}
				else{//case 2. exact match
					dp[i][j]=(dp[i-1][j-1]&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.'));
				}
			}
		}			
		for(int i=0;i<=length1;i++){
			for(int j =0; j<=length2;j++){
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		return dp[length1][length2];
    }
	public static void main(String args[]){
		RegularExpressionMatching rem=new RegularExpressionMatching();
		String s = "a";
		String p ="a*";
		System.out.println(rem.isMatch(s,p));
	}
}