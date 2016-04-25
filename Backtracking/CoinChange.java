import java.util.*;
public class CoinChange {
    HashMap<Integer, Integer> cache = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) return -1;
        if(amount == 0 ) return 0;
		cache.put(0,0);
        helper(coins,amount);
        return cache.containsKey(amount)?cache.get(amount):-1;
    }
    public void helper(int [] coins, int amount){
        if(amount <= 0 || cache.containsKey(amount)){//if already contains...don't go further
            return;
        }
        for(int i = 0; i < coins.length; i++){      
			int num = amount - coins[i];
			if(num<0) continue;
			helper(coins,num);
			if(cache.containsKey(num) && cache.get(num)!=-1){
				int temp = (cache.containsKey(amount)) ? cache.get(amount): Integer.MAX_VALUE;//try to find min..
				cache.put(amount, Math.min(temp,cache.get(num)+1));//update value.
			}
        }
		if(!cache.containsKey(amount)) cache.put(amount,-1);//update invalid value.
    }
	public static void main(String args[]){
		CoinChange cc = new CoinChange();
		int [] coins = {186,419,83,408};
		System.out.println(cc.coinChange(coins,6249));
	}
}