public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
		int length1=s1.length();
		int length2=s2.length();
		int length3=s3.length();
        if (length1+length2!=length3)
			return false;
		boolean [][]dp = new boolean[length1+1][length2+1];
		for(int i=0;i<=length1;i++){
			dp[i][0]=(s1.substring(0,i).equals(s3.substring(0,i))? true:false);
		}
		for(int i=0;i<=length2;i++){
			dp[0][i]=(s2.substring(0,i).equals(s3.substring(0,i))? true:false);
		}
		for(int i=1;i<=length1;i++){
			for(int j =1;j<=length2;j++){
				if(dp[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1)
					||dp[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1))
					dp[i][j]=true;
			}
		}
		for(int i=0;i<=length1;i++){
			for(int j =0;j<=length2;j++){
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
		return dp[length1][length2];
    }
	public static void main(String args[]){
		InterleavingString is= new InterleavingString();
		String s1="a";
		String s2="";
		String s3="a";
		System.out.println(is.isInterleave(s1,s2,s3));
		
	}
}