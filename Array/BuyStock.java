public class BuyStock{
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k > len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
			//hold is means buy stock at cur point
            int hold = t[i - 1][0] - prices[0];
			
			// System.out.println("i="+i+'\t'+hold);
            for (int j = 1; j < len; j++) {
				//find the max with/without cur point, with = cur val - hold val
                t[i][j] = Math.max(t[i][j - 1], prices[j] + hold);
				//update hold, means use the last max value(k-1 tx), and buy at here 
                hold =  Math.max(hold, t[i - 1][j - 1] - prices[j]);
				// System.out.println("j="+j+'\t'+hold);
            }
        }
		// for(int i=0;i<=k;i++){
		// 	for(int j=0;j<len;j++)
		// 		System.out.print(t[i][j]);
		// 	System.out.println();
		// }
        return t[k][len - 1];
    }


    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
	public static void main(String args[]){
		BuyStock bs=new BuyStock();
		int price[]={2,1,3,6,5,7};
		int k=2;
		System.out.println(bs.maxProfit(k,price));
	}
	
	
}