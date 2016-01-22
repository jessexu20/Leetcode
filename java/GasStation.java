public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length<1||cost.length<1) return -1;
        int start=0,tank=0,sum=0;
		for(int i =0;i<gas.length;i++){
			tank=gas[i]-cost[i]+tank;//cur tank left
			if(tank<0){//cannot go over this station
				start=i+1;
				sum+=tank;//all the value in the past i
				tank=0;//empty the tank. start from i+1
			}
		}
		return tank+sum<0?-1:start;//all the gas in the tank and calcuate the sum of i
    }
	public static void main(String args[]){
		int[] gas={2};
		int [] cost={3};
		GasStation gs= new GasStation();
		System.out.println(gs.canCompleteCircuit(gas,cost));
	}
}