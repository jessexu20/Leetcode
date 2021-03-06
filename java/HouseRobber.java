public class HouseRobber {
    public int rob(int[] num) {
	    int rob = 0; //max monney can get if rob current house
	    int notrob = 0; //max money can get if not rob current house
	    for(int i=0; i<num.length; i++) {
	        int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
	        notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
	        rob = currob;
			// System.out.print("currob "+currob);
			// System.out.print(" notrob "+notrob);
			// System.out.println(" rob "+rob);
	    }
	    return Math.max(rob, notrob);
    }
	public static void main(String args[]){
		HouseRobber hr= new HouseRobber();
		int []houses={8,7,6,5};
		System.out.println(hr.rob(houses));
	}
}