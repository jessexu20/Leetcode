public class CoinPick{
	public int maxCoin(int [] arr){
		if(arr.length < 1)
			return 0;
		int [][] dp = new int [arr.length][arr.length];
		int [] sum = new int [arr.length];
		
		for(int i = 0; i < arr.length; i++){
			sum[i] = (i > 0) ? sum[i-1] + arr[i] : arr[i];
		}
		
		for(int i = 0; i < arr.length; i++){
			dp[i][i] = arr[i];
		}
		for(int i = arr.length - 2; i >=0; i--){
			for(int j = i + 1; j < arr.length; j++){
				dp[i][j] = arr[i] + sum[j] - sum[i] - Math.min(dp[i+1][j], dp[i][j-1]);
			}
		}
		// for(int i = 0; i < arr.length; i++){
		// 	for(int j = 0; j < arr.length; j++){
		// 		System.out.print(dp[i][j]+"\t");
		// 	}
		// 	System.out.println();
		// }
		return dp[0][arr.length-1];
	}
	public static void main(String args[]){
		CoinPick cp = new CoinPick();
		int [] arr = {9,8,7,2,99,10};
		// int []arr = {99,10};
		System.out.println(cp.maxCoin(arr));
	}
}