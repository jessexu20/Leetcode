//only buy stock when you sell the current stock and wait for one day
public class BuyStockV{
	public int buy(int [] prices){
		int length = prices.length;
		int hold_cur = 0, hold_day1 = 0, hold_day2 = 0;
		int unhold_cur = 0, unhold_day1 = 0, unhold_day2 = 0;
		hold_day1 = -prices[0];
		unhold_day1 = 0;
		int profit = 0;
		for(int i = 1;i < length; i++){
			if(i > 1) hold_cur = Math.max(hold_day1,unhold_day2 - prices[i]);
			else hold_cur = hold_day1;
			if(i > 1) unhold_cur = Math.max(unhold_day1, hold_day1 + prices[i]);
			else unhold_cur = Math.max(unhold_day1, hold_day1+prices[i]);
			profit = Math.max(unhold_cur,profit);
			hold_day2 = hold_day1;
			hold_day1 = hold_cur;
			unhold_day2 = unhold_day1;
			unhold_day1 = unhold_cur;
		}
		return profit;
	}
	public static void main(String args[]){
		BuyStockV bs = new BuyStockV();
		int [] nums = {2,3,1,4,5,1,6};
		System.out.println(bs.buy(nums));
	}
}