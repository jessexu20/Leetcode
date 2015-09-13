public class EditDistance {
    public int minDistance(String word1, String word2) {
		int length1=word1.length();
		int length2=word2.length();
		int [][]dp= new int [length1+1][length2+1];
		for(int i=0;i<=length1;i++){
			dp[i][0]=i;
		}
		for(int i=0;i<=length2;i++){
			dp[0][i]=i;
		}
		for(int i=1;i<=length1;i++){
			for(int j=1;j<=length2;j++){
				if(word1.charAt(i-1)==word2.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1];
				}
				else
					dp[i][j]=1+getMin(dp[i-1][j-1],dp[i][j-1],dp[i-1][j]);
			}
		}
		// for(int i=0;i<=length1;i++){
		// 	for(int j=0;j<=length2;j++){
		// 		System.out.print(dp[i][j]+"\t");
		// 	}
		// 	System.out.println();
		// }
        return dp[length1][length2];
    }
	public int getMin(int a,int b,int c){
		return (a<b ? a:b)<c ? (a<b ? a:b):c;
	}
	public static void main(String args[]){
		EditDistance ed= new EditDistance();
		System.out.println(ed.minDistance("zoologicoarchaeologist", "zoogeologist"));
	}
}