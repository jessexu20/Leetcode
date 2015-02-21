public class BuyStockIII{
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<1)
            return 0;
        int k=2;

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
        return t[k][len - 1];
    }
	public static void main(String args[]){
		BuyStockIII bs=new BuyStockIII();
		int price[]={6,1,5,3,2,4};
		System.out.println(bs.maxProfit(price));
	}

}