public class WildcardMatching {
    public boolean isMatch(String s, String p) {
		int length1=s.length();
		int length2=p.length();
		boolean star=true;
		for(int i=0;i<length2;i++){
			if(p.charAt(i)!='*'){
				star=false;
				break;
			}
		}
		if(length2==0&&length1!=0)
		    return false;
		if(star)
			return true;
		boolean [][]dp=new boolean[length1+1][length2+1];
		dp[0][0]=true;
		for(int i=1;i<=length2;i++){
			if(p.charAt(i-1)=='*'){
				dp[0][i]=dp[0][i-1];
			}
			else{
				dp[0][i]=false;
			}
		}
		for(int i=1;i<=length1;i++){
			for(int j=1;j<=length2;j++){
				if(p.charAt(j-1)=='*'){
					dp[i][j]=dp[i-1][j-1]||dp[i-1][j]||dp[i][j-1];
				}
				else{
					dp[i][j]=dp[i-1][j-1]&&((s.charAt(i-1)==p.charAt(j-1))||p.charAt(j-1)=='?');
				}
			}
		}
		// for(int i=0;i<=length1;i++){
		// 	for(int j =0; j<=length2;j++){
		// 		System.out.print(dp[i][j]+"\t");
		// 	}
		// 	System.out.println();
		// }
		return dp[length1][length2];
    }
	public static void main(String args[]){
		WildcardMatching wm=new WildcardMatching();
		String s = "c";
		String p ="*?*";
		System.out.println(wm.isMatch(s,p));
	}
}