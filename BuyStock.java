public class BuyStock{
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k > len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = t[i - 1][0] - prices[0];
			// System.out.println("i="+i+'\t'+tmpMax);
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
				// System.out.println("j="+j+'\t'+tmpMax);
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
		int price[]={6,1,5,3,2,4};
		int k=2;
		System.out.println(bs.maxProfit(k,price));
	}
	
	
}