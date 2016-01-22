public class BuyFruit{
	public int minfruit(int money, int [] prices){
		int [] dp = new int [money+1];
		dp[0] = 0;
		for(int i = 1; i <= money; i++){
			int min = Integer.MAX_VALUE;
			for(int j = prices.length-1; j>=0 ; j--){
				int temp = i - prices[j];
				if(temp < 0) continue;
				min = Math.min(dp[temp],min);
				if(min == 1){
					break;
				}
			}
			dp[i] = (min == Integer.MAX_VALUE) ? 0 : min+1; 
		}
		for(int i : dp)
			System.out.print(i+"\t");
		return dp[money];
	}
	public static void main(String args[]){
		BuyFruit bf = new BuyFruit();
		int [] prices = {2,5,6};
		System.out.println(bf.minfruit(10, prices));
	}
}