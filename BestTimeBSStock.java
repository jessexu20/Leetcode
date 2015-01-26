public class BestTimeBSStock{
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
		int profit=0;
		for(int i =0 ;i<prices.length;i++){
			min=Math.min(min,prices[i]);
			profit=Math.max(profit,prices[i]-min);
		}
		return profit;
    }
	public static void main(String args[]){
		BestTimeBSStock bt=new BestTimeBSStock();
		int [] num = {2,3,4,1,2,3,8,5};
		System.out.println(bt.maxProfit(num));
	}
}